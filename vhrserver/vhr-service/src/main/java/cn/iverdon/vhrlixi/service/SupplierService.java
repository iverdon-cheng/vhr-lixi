package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.SupplierMapper;
import cn.iverdon.vhrlixi.model.Client;
import cn.iverdon.vhrlixi.model.RespPageBean;
import cn.iverdon.vhrlixi.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2022/3/1 15:29
 */
@Service
public class SupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    public List<Supplier> getAllSuppliers() {
        return supplierMapper.getAllSuppliers();
    }

    public RespPageBean getSuppliersByPage(Integer page, Integer size, Supplier supplier) {
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Supplier> data = supplierMapper.getSuppliersByPage(page, size, supplier);
        Long total = supplierMapper.getTotal(supplier);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }
}
