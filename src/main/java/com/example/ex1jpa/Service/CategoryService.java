package com.example.ex1jpa.Service;

import com.example.ex1jpa.Model.category;
import com.example.ex1jpa.Repostiry.CategoryRepostiry;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
private final CategoryRepostiry categoryRepostiry;
    public List<category> getCategory(){
        return categoryRepostiry.findAll();
    }
    public void addCategory(category category){
        categoryRepostiry.save(category);
    }
    public boolean updateCategory(Integer id,category category){
        category c = categoryRepostiry.getById(id);
        if(c == null){
            return false;
        }
        c.setCategoryName(category.getCategoryName());
        categoryRepostiry.save(c);
        return true;}

    public boolean deleteCategory(Integer id){
        category c = categoryRepostiry.getById(id);
        if(c == null){
            return false;
        }
        categoryRepostiry.deleteById(id);
        return true;
    }



}
