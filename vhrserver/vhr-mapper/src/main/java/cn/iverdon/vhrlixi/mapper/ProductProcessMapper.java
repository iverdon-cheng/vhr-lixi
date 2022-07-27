package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.ProductProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iverdon
 * @date 2021/6/13 17:44
 */
public interface ProductProcessMapper {
    int insertBatch(@Param("list") List<ProductProcess> productProcesses);

    List<ProductProcess> getProductProcessByQuotationNum(String quotationNum);

    int updateBatch(@Param("list") List<ProductProcess> productProcesses);

    int deleteBatch(@Param("list") List<ProductProcess> productProcesses);
}
