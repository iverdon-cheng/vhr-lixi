package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.config.FastDFSUtils;
import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.service.HrService;
import org.csource.fastdfs.ProtoCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Map;

/**
 * @author iverdon
 * @date 2020/9/24 16:18
 */
@RestController
public class HrInfoController {

    @Autowired
    HrService hrService;

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication){
        return (Hr) authentication.getPrincipal();
    }

    @PutMapping("/hr/info")
    public RespBean updateHr(@RequestBody Hr hr, Authentication authentication){
        if (hrService.updateHr(hr) == 1){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PutMapping("/hr/pass")
    public RespBean updateHrPasswd(@RequestBody Map<String,Object> info){
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrid");
        if (hrService.updateHrPasswd(oldPass, pass, hrid)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PostMapping("/hr/userFace")
    public RespBean updateHrUserFace(MultipartFile file, Integer id, Authentication authentication){
        System.out.println(file.getName());
        String fileId = FastDFSUtils.upload(file);
        System.out.println(fileId);
        if (hrService.updateUserFace(fileId,id) == 1){
            Hr hr = (Hr) authentication.getPrincipal();
            hr.setUserFace(nginxHost+FastDFSUtils.getToken(fileId));
            System.out.println(nginxHost+FastDFSUtils.getToken(fileId));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！",fileId);
        }
        return RespBean.error("更新失败！");
    }
}
