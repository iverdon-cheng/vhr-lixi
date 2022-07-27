package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Quotation;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @author iverdon
 * @date 2021/3/9 18:55
 */
public interface QuotationMapper {

    List<Quotation> getQuotationByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("quotation") Quotation quotation);

    Long getTotal(@Param("quotation") Quotation quotation);

    String getLatestNum();

    Quotation getQuotationWithProducts(@Param("quotationNum") String quotationNum);

    int insertQuotation(Quotation quotation);

    int deleteQuotation(@Param("quotationNum") String quotationNum);

    int updateQuotation(Quotation quotation);
}
