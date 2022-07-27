package cn.iverdon.vhrlixi.controller.ord;

import cn.iverdon.vhrlixi.config.FastDFSUtils;
import cn.iverdon.vhrlixi.model.Product;
import cn.iverdon.vhrlixi.model.RespBean;
import cn.iverdon.vhrlixi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author iverdon
 * @date 2021/6/3 16:37
 */
@RestController
@RequestMapping("/order/product/")
public class ProductController {

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @Autowired
    ProductService productService;

    @PostMapping("/upload")
    public RespBean uploadFile(MultipartFile file){
        String fileId = FastDFSUtils.upload(file);
        System.out.println(fileId);
        return RespBean.ok("上传成功！",nginxHost+FastDFSUtils.getToken(fileId));
    }

    @PostMapping("/products/")
    public RespBean addProducts(@RequestBody Product[] products,@RequestParam(value = "clientNum") String quotationNum){
        System.out.println(quotationNum+"----add"+products.length);
        if (products != null && products.length != 0){
            productService.addProducts(products,quotationNum);
        }

        return RespBean.ok("新增成功");
    }

    @DeleteMapping("/products/")
    public RespBean deleteProducts(@RequestBody Product[] products,@RequestParam(value = "clientNum") String quotationNum){
        System.out.println(quotationNum+"----de"+products.length);
        if(products != null && products.length != 0){
            System.out.println();
            productService.deleteProduct(products,quotationNum);
            for (Product p:products){
                String[] s = p.getUrl().split("\\?");
                p.setUrl(s[0].substring(22));
            }
            for (Product product:products){
                System.out.println(product.getUrl());
                FastDFSUtils.delete(product.getUrl());
            }
        }
        return RespBean.ok("删除成功");
    }

    @PutMapping("/products/")
    public RespBean updateProducts(@RequestBody Product[] products, @RequestParam(value = "clientNum") String quotationNum){
        System.out.println("----update"+products.length);
        if (products != null && products.length != 0){
            productService.updateProducts(products,quotationNum);
        }
        return RespBean.ok("修改成功");
    }

    @DeleteMapping("/urls/")
    public RespBean deleteUrls(@RequestBody String[] urls){
        for (String s : urls){
            String[] temp = s.split("\\?");
            String t = temp[0].substring(22);
            FastDFSUtils.delete(t);
        }
        return RespBean.ok("文件删除成功");
    }
}
