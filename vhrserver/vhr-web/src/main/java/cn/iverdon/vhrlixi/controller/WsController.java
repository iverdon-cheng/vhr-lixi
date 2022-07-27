package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.model.ChatMsg;
import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * @author iverdon
 * @date 2020/9/9 12:54
 */
@Controller
public class WsController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg msg){
        System.out.println(msg.getTo());
        Hr hr = (Hr)authentication.getPrincipal();
        msg.setFrom(hr.getUsername());
        msg.setFromNickname(hr.getName());
        msg.setDate(new Date());
        simpMessagingTemplate.convertAndSendToUser(msg.getTo(),"/queue/chat",msg);
    }

}
