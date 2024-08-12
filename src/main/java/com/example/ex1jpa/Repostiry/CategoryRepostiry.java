package com.example.ex1jpa.Repostiry;

import com.example.ex1jpa.Model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepostiry extends JpaRepository<category, Integer> {

}
