package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.model.Hr;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iverdon
 * @date 2020/9/24 16:18
 */
@RestController
public class HrInfoController {


    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication){
        return (Hr) authentication.getPrincipal();
    }
}
