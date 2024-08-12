package com.example.ex1jpa.Repostiry;

import com.example.ex1jpa.Model.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MerchantStockRepostiry extends JpaRepository<MerchantStock, Integer> {
}
