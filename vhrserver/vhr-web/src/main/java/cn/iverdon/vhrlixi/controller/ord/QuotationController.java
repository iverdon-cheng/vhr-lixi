package cn.iverdon.vhrlixi.controller.ord;

import cn.iverdon.vhrlixi.config.FastDFSUtils;
import cn.iverdon.vhrlixi.model.*;
import cn.iverdon.vhrlixi.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

/**
 * @author iverdon
 * @date 2021/3/9 18:41
 */
@RestController
@RequestMapping("/order/quotation")
public class QuotationController {

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @Autowired
    QuotationService quotationService;


    @GetMapping("/")
    public RespPageBean getQuotationByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Quotation order){
        return quotationService.getQuotationByPage(page,size,order);
    }

    @PostMapping("/")
    public RespBean addQuotation(@RequestBody Quotation quotation){
        if (quotationService.addQuotation(quotation) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteQuotation(@PathVariable String quotationNum){
        if (quotationService.deleteQuotation(quotationNum)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateQuotation(@RequestBody Quotation quotation){
        if (quotationService.updateQuotation(quotation) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @GetMapping("/quotationNum")
    public RespBean getQuotationNum(){
        return RespBean.build().setStatus(200)
                .setObj(quotationService.getQuotationNum());
    }

    @GetMapping("/quotationWithProduct")
    public RespBean getQuotationWithProduct(@RequestParam String quotationNum){
        System.out.println(quotationNum);
        Quotation quotation = quotationService.getQuotationWithProduct(quotationNum);
        for (Product p : quotation.getProducts()){
            if (p.getUrl().length() >= 7){
                System.out.println(p.getUrl()+"sdfsdfsdfsdf");
                p.setUrl(nginxHost+FastDFSUtils.getToken(p.getUrl()));
                System.out.println(p.getUrl());
            }
        }

        return RespBean.build().setStatus(200)
                .setObj(quotation);
    }




//    @PostMapping("/")
//    public RespBean addQuotation(@RequestBody Quotation quotation){
//        if (quotationService.addQuotaion(quotation) == 1){
//            return RespBean.ok("添加成功");
//        }
//        return RespBean.error("添加失败！");
//    }
}
