package cn.iverdon.vhrlixi.mapper;


import cn.iverdon.vhrlixi.model.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper  {

    int insertProduct(Product product);

    int deleteById(@Param("id") Integer id);

    void deleteProduct(Product[] products);

    void insertProducts(@Param("array") Product[] products);

    void deleteProductsByName(@Param("array") Product[] products);

    void updateProducts(@Param("array") Product[] products);
}