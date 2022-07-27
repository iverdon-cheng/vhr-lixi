package cn.iverdon.vhrlixi.controller;

import cn.iverdon.vhrlixi.config.VerificationCode;
import cn.iverdon.vhrlixi.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code",text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
