package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    HrService hrService;
    @GetMapping("/hrs")
    public List<Hr> getAllHrs() {
        return hrService.getAllHrsExceptCurrentHr();
    }
}
