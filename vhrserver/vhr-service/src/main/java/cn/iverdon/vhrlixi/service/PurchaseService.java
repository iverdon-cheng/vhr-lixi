package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.PurchaseMapper;
import cn.iverdon.vhrlixi.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    PurchaseMapper purchaseMapper;
    public int addPurchase(Purchase purchase) {
        System.out.println(purchaseMapper.insertPurchase(purchase));
        return 1;
    }
}
