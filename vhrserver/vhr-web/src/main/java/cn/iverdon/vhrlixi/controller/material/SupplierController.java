package cn.iverdon.vhrlixi.controller.material;

import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.model.RespPageBean;
import cn.iverdon.vhrlixi.model.Supplier;
import cn.iverdon.vhrlixi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/10/23 10:49
 */
@RestController
@RequestMapping("/material/suppliers")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/")
    public RespPageBean getALLSuppliers(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Supplier supplier){
        return supplierService.getSuppliersByPage(page, size, supplier);
    }
}
