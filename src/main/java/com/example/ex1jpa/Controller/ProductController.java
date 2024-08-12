package com.example.ex1jpa.Controller;

import com.example.ex1jpa.Model.MerchantStock;
import com.example.ex1jpa.Model.Product;
import com.example.ex1jpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")

public class ProductController {
    private final ProductService productService;
    @GetMapping("/get")
    public ResponseEntity getProduct() {
        return ResponseEntity.status(200).body(productService.getProduct());
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body("Successfully added");
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity updateProduct(@PathVariable Integer id,@Valid @RequestBody Product product , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = productService.updateProduct(id,product);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        boolean isDeleted = productService.deleteProduct(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Successfully deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }
    @PutMapping("/set/{UserID}/{ProductID}/{MerchantID}")
    public ResponseEntity buyProduct(@PathVariable Integer userID,@PathVariable Integer productID,@PathVariable Integer merchantID) {
        int isSet = productService.buyProduct(userID,productID,merchantID);
        if (isSet==1) {
            return ResponseEntity.status(400).body("Out of stock");
        }if(isSet==2){
            return ResponseEntity.status(400).body("Balance is less than the product price");
        }
        return ResponseEntity.status(200).body("Successfully set");
    }
    @PutMapping("/discount/{userID}/{productID}")
    public ResponseEntity discount(@PathVariable Integer userID,@PathVariable Integer productID) {
        boolean isDiscount = productService.discount(userID,productID);
        if (isDiscount) {
            return ResponseEntity.status(200).body("Successfully discount");
        }
        return ResponseEntity.status(400).body("Not found");
    }

}
