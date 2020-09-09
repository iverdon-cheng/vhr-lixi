package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iverdon
 * @date 2020/7/13 11:27 上午
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请登录!");
    }
}
