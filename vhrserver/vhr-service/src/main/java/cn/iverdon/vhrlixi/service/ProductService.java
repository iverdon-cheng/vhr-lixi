package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.ProductMapper;
import cn.iverdon.vhrlixi.mapper.QuotationProductMapper;
import cn.iverdon.vhrlixi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author iverdon
 * @date 2021/6/3 23:31
 */
@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    QuotationProductMapper quotationProductMapper;



    public Integer addProduct(Product product) {
        return productMapper.insertProduct(product);
    }

    @Transactional
    public Integer deleteProduct(Product[] products, String quotationNum){
        int num = 0;
        productMapper.deleteProductsByName(products);
        System.out.println(quotationNum);
        if (quotationNum != null){
            System.out.println(quotationNum);
            quotationProductMapper.deleteQuoProducts(products, quotationNum);
        }
        System.out.println("删除成功");
        return num;
    }

    public void addProducts(Product[] products, String quotationNum) {
        if (products == null){
            System.out.println("无插入成功");
            return;
        }
        for (Product p:products){
            String[] s = p.getUrl().split("\\?");
            p.setUrl(s[0].substring(22));
            productMapper.insertProduct(p);
            System.out.println(p.getId());
        }
        if (quotationNum != null){
            System.out.println(products[0].getId());
            quotationProductMapper.insertAll(products,quotationNum);
        }
        System.out.println("插入成功");
    }

    public void updateProducts(Product[] products,String quotationNum) {
        for (Product p:products){
            if (p.getUrl().length() >= 22){
                String[] s = p.getUrl().split("\\?");
                p.setUrl(s[0].substring(22));
            }
        }
        quotationProductMapper.updateBatch(products,quotationNum);
        productMapper.updateProducts(products);
        System.out.println("更新成功");
    }

}
