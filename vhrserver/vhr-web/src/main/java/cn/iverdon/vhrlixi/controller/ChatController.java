package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.config.FastDFSUtils;
import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/9/9 12:51
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Value("${fastdfs.nginx.host}")
    String nginxHost;
    @Autowired
    HrService hrService;
    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        List<Hr> hrs = hrService.getAllHrsExceptCurrentHr();
        for (Hr hr : hrs){
            hr.setUserFace(nginxHost+FastDFSUtils.getToken(hr.getUserFace()));
            System.out.println(hr.getUserFace());
        }
        return hrs;
    }
}
