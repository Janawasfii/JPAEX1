package com.example.ex1jpa.Controller;

import com.example.ex1jpa.Model.MerchantStock;
import com.example.ex1jpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/merchantStock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStock() {
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock (@Valid @RequestBody MerchantStock merchantStock , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("MerchantStock Successfully added");
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity updateMerchantStock(@PathVariable Integer id,@Valid @RequestBody MerchantStock merchantStock , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer id) {
        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Successfully deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }
    @PutMapping("/changestock/{productID}/{MerchantID}/{MerchantStockID}/{stock}")
    public  ResponseEntity updateMerchantStock(@PathVariable Integer productID,@PathVariable Integer MerchantID,@PathVariable Integer MerchantStockID,@PathVariable Integer stock ){
        boolean isUpdated = merchantStockService.changeStock(productID,MerchantID,MerchantStockID,stock);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Not found");
    }


    @PutMapping("/set/{orderID}/{userID}/{productID}/{merchantID}")
    public ResponseEntity changeStatus(@PathVariable Integer orderID,@PathVariable Integer userID, @PathVariable Integer productID, @PathVariable Integer merchantID) {
        boolean isUpdated = merchantStockService.changeStatus(orderID,userID,productID,merchantID);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Not found");
    }


}
