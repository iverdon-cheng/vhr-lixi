package cn.iverdon.vhrlixi.controller.purchase;

import cn.iverdon.vhrlixi.model.ChatMsg;
import cn.iverdon.vhrlixi.model.Hr;
import cn.iverdon.vhrlixi.model.Purchase;
import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/")
    public RespBean addPurchase(@RequestBody Purchase purchase, Authentication authentication){
        Hr hr = (Hr)authentication.getPrincipal();
        purchase.setApplyId(hr.getId());
        purchase.setChiefId(3);
        purchase.setPurchaseId(7);
        if (purchaseService.addPurchase(purchase) == 1){
            ChatMsg msg = new ChatMsg();
            msg.setFrom(hr.getUsername());
            msg.setFromNickname(hr.getName());
            msg.setContent("新的采购申请单请审批！");
            System.out.println(simpMessagingTemplate.getMessageChannel());
            msg.setTo("admin");
            simpMessagingTemplate.convertAndSendToUser("admin","/queue/chat",msg);
            msg.setTo("libai");
            simpMessagingTemplate.convertAndSendToUser("libai","/queue/chat",msg);
            return RespBean.ok("申请成功，等待审批！");
        }
        return RespBean.error("申请失败，请重新申请！");
    }
}
