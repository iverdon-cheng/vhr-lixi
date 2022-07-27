package cn.iverdon.vhrlixi.controller.ord;

import cn.iverdon.vhrlixi.model.ProductProcess;
import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.service.ProductProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/6/13 17:29
 */
@RestController
@RequestMapping("/order/productProcess")
public class ProductProcessController {

    @Autowired
    ProductProcessService productProcessService;

    @PostMapping
    public RespBean insertProductProcesses(@RequestBody List<ProductProcess> productProcesses){
        if (productProcesses.size() > 0){
            return productProcessService.insertBatch(productProcesses) >= 0 ? RespBean.ok("添加成功"):RespBean.error("添加失败！");
        }
        return RespBean.ok("添加成功");
    }

    @PutMapping
    public RespBean updateProductProcesses(@RequestBody List<ProductProcess> productProcesses){
        if (productProcesses.size() > 0){
            return productProcessService.updateBatch(productProcesses) >= 0 ? RespBean.ok("更新成功"):RespBean.error("更新失败！");
        }
        return RespBean.ok("更新成功");
    }

    @DeleteMapping
    public RespBean deleteProductProcesses(@RequestBody List<ProductProcess> productProcesses){
        System.out.println(productProcesses.size()+"ksldfhdsf");
        if (productProcesses.size() > 0){
            return productProcessService.deleteBatch(productProcesses) >= 0 ? RespBean.ok("删除成功"):RespBean.error("删除失败！");
        }
        System.out.println("asfdfdsfd");
        return RespBean.ok("删除成功");
    }

    @GetMapping("/quotationWithProductProcess")
    public RespBean getProductProcessByQuotationNum(@RequestParam String quotationNum){
        List<ProductProcess> list = productProcessService.getProductProcessByQuotationNum(quotationNum);
        return RespBean.ok("查询成功",list);
    }

}
