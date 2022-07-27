package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.ProductProcessMapper;
import cn.iverdon.vhrlixi.model.ProductProcess;
import cn.iverdon.vhrlixi.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/6/13 17:42
 */
@Service
public class ProductProcessService {

    @Autowired
    ProductProcessMapper productProcessMapper;

    public int insertBatch(List<ProductProcess> productProcesses) {
        return productProcessMapper.insertBatch(productProcesses);
    }

    public List<ProductProcess> getProductProcessByQuotationNum(String quotationNum) {
        return productProcessMapper.getProductProcessByQuotationNum(quotationNum);
    }

    public int updateBatch(List<ProductProcess> productProcesses) {
        return productProcessMapper.updateBatch(productProcesses);
    }

    public int deleteBatch(List<ProductProcess> productProcesses) {
        return productProcessMapper.deleteBatch(productProcesses);

    }
}