package com.example.ex1jpa.Repostiry;

import com.example.ex1jpa.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepostiry extends JpaRepository<Product, Integer> {
}
