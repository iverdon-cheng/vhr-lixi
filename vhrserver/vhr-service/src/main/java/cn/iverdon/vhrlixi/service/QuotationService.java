package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.ProductMapper;
import cn.iverdon.vhrlixi.mapper.QuotationMapper;
import cn.iverdon.vhrlixi.mapper.QuotationProductMapper;
import cn.iverdon.vhrlixi.model.Product;
import cn.iverdon.vhrlixi.model.Quotation;
import cn.iverdon.vhrlixi.model.QuotationProduct;
import cn.iverdon.vhrlixi.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author iverdon
 * @date 2021/3/9 18:44
 */
@Service
public class QuotationService {

    @Autowired
    QuotationMapper quotationMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    QuotationProductMapper qpMapper;

    public RespPageBean getQuotationByPage(Integer page, Integer size, Quotation quotation) {
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Quotation> data = quotationMapper.getQuotationByPage(page, size, quotation);
        Long total = quotationMapper.getTotal(quotation);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public String getQuotationNum() {
        String latestNum = quotationMapper.getLatestNum();
        String now = new SimpleDateFormat("yyMM").format(new Date());
        if (latestNum == null || !latestNum.substring(1,5).equals(now)){
            return new String("Q").concat(now).concat(String.format("%05d",1));
        }else {
            String num = latestNum.substring(5);
            int temp = Integer.parseInt(num)+1;
            return latestNum.substring(0,5).concat(String.format("%05d",temp));
        }
    }

    public Quotation getQuotationWithProduct(String quotationNum){
        System.out.println(quotationMapper.getQuotationWithProducts(quotationNum).getName());
        return quotationMapper.getQuotationWithProducts(quotationNum);
    }

    @Transactional
    public int addQuotation(Quotation quotation) {
        int result = quotationMapper.insertQuotation(quotation);
        if (quotation.getProducts()!=null){
            for (Product product : quotation.getProducts()){
                int id = productMapper.insertProduct(product);
                qpMapper.insert(quotation.getClientNum(),product.getId());
            }
        }
        return result;
    }

    @Transactional
    public int deleteQuotation(String quotationNum) {
        int result =  quotationMapper.deleteQuotation(quotationNum);
        qpMapper.deleteByQuoNum(quotationNum);
        return result;
    }

    public int updateQuotation(Quotation quotation) {
        return quotationMapper.updateQuotation(quotation);
    }
}
