package cn.iverdon.vhrlixi.controller.ord;

import cn.iverdon.vhrlixi.model.Quotation;
import cn.iverdon.vhrlixi.model.RespPageBean;
import cn.iverdon.vhrlixi.service.QuotationCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iverdon
 * @date 2021/5/29 21:47
 */
@RestController
@RequestMapping("/order/quotationCost")
public class QuotationCostController {

    @Autowired
    QuotationCostService quotationCostService;

    @GetMapping("/")
    public RespPageBean getQuotationCost(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        return quotationCostService.getQuotationCost(page,size);
    }

}
