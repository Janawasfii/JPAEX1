package com.example.ex1jpa.Repostiry;

import com.example.ex1jpa.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MerchantRepostiry extends JpaRepository<Merchant, Integer> {
}
