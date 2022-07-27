package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.QuotationCostMapper;
import cn.iverdon.vhrlixi.model.Quotation;
import cn.iverdon.vhrlixi.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/5/29 21:49
 */
@Service
public class QuotationCostService {

    @Autowired
    QuotationCostMapper quotationCostMapper;

    public RespPageBean getQuotationCost(Integer page, Integer size) {
        if (page != null || size != null){
            page = (page-1)*size;
        }
        List<Quotation> data = quotationCostMapper.getQuotationCostByPage(page, size);
        Long total = quotationCostMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

}
