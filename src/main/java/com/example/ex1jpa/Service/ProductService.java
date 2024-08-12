package com.example.ex1jpa.Service;

import com.example.ex1jpa.Model.Merchant;
import com.example.ex1jpa.Model.MerchantStock;
import com.example.ex1jpa.Model.Product;

import com.example.ex1jpa.Model.User;
import com.example.ex1jpa.Repostiry.MerchantRepostiry;
import com.example.ex1jpa.Repostiry.MerchantStockRepostiry;
import com.example.ex1jpa.Repostiry.ProductRepostiry;
import com.example.ex1jpa.Repostiry.UserRepostiry;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class ProductService {
   private final ProductRepostiry productRepostiry;
    private final MerchantStockRepostiry merchantStockRepostiry;
    private final UserRepostiry userRepostiry;


    public List<Product> getProduct() {
        return productRepostiry.findAll();
    }
    public void addProduct(Product product) {
        productRepostiry.save(product);
    }
    public boolean updateProduct(Integer id, Product product) {
        Product p = productRepostiry.getById(id);
        if (p == null) {
            return false;
        }
        p.setProductName(product.getProductName());
        p.setProductPrice(product.getProductPrice());
        productRepostiry.save(p);
        return true;
    }
    public boolean deleteProduct(Integer id) {
         Product p= productRepostiry.getById(id);
        if (p == null) {
            return false;
        }
        productRepostiry.deleteById(id);
        return true;
    }
    public int buyProduct(Integer userID,Integer productID,Integer merchantID){
        Product p = productRepostiry.getById(productID);
        User u = userRepostiry.getById(userID);
        MerchantStock ms = merchantStockRepostiry.getById(merchantID);
        if(p != null){
            if(u != null){
                if(ms != null){
                    if(ms.getStock()>0){
                        ms.setStock(ms.getStock()-1);
                        merchantStockRepostiry.save(ms);
                    }else return 1;}
                         if(u.getBalance()>=p.getProductPrice()){
                             u.setBalance(u.getBalance()-p.getProductPrice());
                             userRepostiry.save(u);
                               }else return 2;}}
        return 0;
    }

    public boolean discount(Integer userID,Integer productID){
        Product p = productRepostiry.getById(productID);
        User u = userRepostiry.getById(userID);
        if(u != null && u.getRole().equalsIgnoreCase("Admin")){
            if(p != null){
                if(p.getProductPrice() > 1500){
                    //*0.20
                    p.setProductPrice(p.getProductPrice()- p.getProductPrice()- 500);
                    productRepostiry.save(p);
                }
            }
        }
        return false;
    }


}
