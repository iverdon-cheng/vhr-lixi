package cn.iverdon.vhrlixi.controller.system;

import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.model.Role;
import cn.iverdon.vhrlixi.service.HrService;
import cn.iverdon.vhrlixi.service.RoleService;
import cn.iverdon.vhrlixi.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/15 0:11
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrService.updateHr(hr) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRoles(Integer hrid, Integer[] rids){
        if (hrService.updateHrRoles(hrid, rids)) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id){
        if (hrService.deleteHrById(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
