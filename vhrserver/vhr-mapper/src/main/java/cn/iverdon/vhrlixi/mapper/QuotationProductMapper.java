package cn.iverdon.vhrlixi.mapper;


import cn.iverdon.vhrlixi.model.Product;
import org.apache.ibatis.annotations.Param;

public interface QuotationProductMapper  {

    int insert(@Param("clientNum") String clientNum, @Param("id") int id);

    int deleteByQuoNum(@Param("quotationNum") String quotationNum);

    int insertByName(@Param("name") String name, @Param("quotationNum") String quotationNum);


    int insertAll( @Param("array") Product[] products, @Param("quotationNum") String quotationNum);

    int deleteQuoProducts(@Param("array")Product[] products,@Param("quotationNum") String quotationNum);

    int updateBatch(@Param("array")Product[] products,@Param("quotationNum") String quotationNum);
}