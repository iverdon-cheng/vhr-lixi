package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Quotation;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/5/29 21:58
 */
public interface QuotationCostMapper {

    List<Quotation> getQuotationCostByPage(Integer page, Integer size);

    Long getTotal();
}
