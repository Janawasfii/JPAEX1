package com.example.ex1jpa.Service;

import com.example.ex1jpa.Model.Merchant;
import com.example.ex1jpa.Model.MerchantStock;
import com.example.ex1jpa.Model.Product;
import com.example.ex1jpa.Model.User;
import com.example.ex1jpa.Repostiry.MerchantRepostiry;
import com.example.ex1jpa.Repostiry.MerchantStockRepostiry;
import com.example.ex1jpa.Repostiry.ProductRepostiry;
import com.example.ex1jpa.Repostiry.UserRepostiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class MerchantStockService {
    private final MerchantStockRepostiry merchantStockRepostiry;
    private final ProductRepostiry productRepostiry;
    private final UserRepostiry userRepostiry;
    private final MerchantRepostiry merchantRepostiry;


    public List<MerchantStock> getMerchantStock() {
        return merchantStockRepostiry.findAll();
    }

    public void addMerchantStock (MerchantStock merchantStock) {
        merchantStockRepostiry.save(merchantStock);
    }

    public boolean updateMerchantStock (Integer id,MerchantStock merchantStock) {
        MerchantStock m = merchantStockRepostiry.getById(id);

        if (m == null) {
            return false;
        }
        m.setProductID(merchantStock.getProductID());
        m.setMerchantID(merchantStock.getMerchantID());
        m.setStock(merchantStock.getStock());

        merchantStockRepostiry.save(m);
        return true;
    }
    public boolean deleteMerchantStock (Integer id) {
        MerchantStock m = merchantStockRepostiry.getById(id);
        if (m == null) {
            return false;
        }
        merchantStockRepostiry.delete(m);
        return true;
    }
    public boolean changeStock (Integer productID,Integer MerchantID,Integer MerchantStockID, int stock) {
        MerchantStock m = merchantStockRepostiry.getById(MerchantStockID);
        if(m.getProductID() == productID){
            if(m.getMerchantID()==MerchantID){
                if(m.getStock()>0){
                    m.setStock(m.getStock()+stock);
                    merchantStockRepostiry.save(m);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean changeStatus(Integer orderID,Integer userID,Integer productID,Integer merchantID){
        Product p = productRepostiry.getById(productID);
        User u = userRepostiry.getById(userID);
       Merchant m =merchantRepostiry.getById(merchantID);
       Merchant m1=  merchantRepostiry.getById(orderID);
        if(m.getStatus().equals("PLACED")){
            m.setStatus("PROCESSING");}
        else if(m.getStatus().equals("PROCESSING")){
            m.setStatus("SHIPPED");}
        else if(m.getStatus().equals("SHIPPED")){
            m.setStatus("DELIVERED");}
        return true;}

        }




