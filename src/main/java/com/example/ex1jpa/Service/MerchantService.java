package com.example.ex1jpa.Service;

import com.example.ex1jpa.Model.Merchant;
import com.example.ex1jpa.Repostiry.MerchantRepostiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepostiry merchantRepostiry;

    public List<Merchant> getMerchants() {
        return merchantRepostiry.findAll();
    }
    public void addMerchant(Merchant merchant) {
        merchantRepostiry.save(merchant);
    }
    public boolean updateMerchant(Integer id,Merchant merchant) {
        Merchant m = merchantRepostiry.getById(id);
        if (m == null) {
            return false;
        }
        m.setMerchantName(merchant.getMerchantName());
        m.setStatus(merchant.getStatus());
       // m.setOrderId(merchant.getOrderId());
        merchantRepostiry.save(m);
        return true;
    }
    public boolean deleteMerchant(Integer id) {
        Merchant m = merchantRepostiry.getById(id);
        if (m == null) {
            return false;
        }
        merchantRepostiry.deleteById(id);
        return true;
    }

}
