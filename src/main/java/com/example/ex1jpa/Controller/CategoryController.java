package com.example.ex1jpa.Controller;

import com.example.ex1jpa.Model.category;
import com.example.ex1jpa.Service.CategoryService;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body("Successfully Added");}

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@Valid @RequestBody category category, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = categoryService.updateCategory(id,category);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully Updated");
        }
            return ResponseEntity.status(400).body("Not Found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee(@PathVariable Integer id) {
        boolean isDeleted = categoryService.deleteCategory(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Successfully Deleted");
        }
        return ResponseEntity.status(400).body("Not Deleted");
    }



}

