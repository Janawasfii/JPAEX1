package com.example.ex1jpa.Controller;

import com.example.ex1jpa.Model.MerchantStock;
import com.example.ex1jpa.Model.User;
import com.example.ex1jpa.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")

public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser (@Valid @RequestBody User user , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(" Successfully added");
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity updateUser(@PathVariable Integer id,@Valid @RequestBody User user , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id,user);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Successfully deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }
}
