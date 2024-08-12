package com.example.ex1jpa.Service;

import com.example.ex1jpa.Model.Product;
import com.example.ex1jpa.Model.User;
import com.example.ex1jpa.Model.category;
import com.example.ex1jpa.Repostiry.UserRepostiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepostiry userRepostiry;
    public List<User> getUser() {
        return userRepostiry.findAll();
    }
    public void addUser(User user) {
        userRepostiry.save(user);
    }
    public boolean updateUser(Integer id, User user) {
        User u = userRepostiry.getById(id);
        if (u == null) {
            return false;
        }
        u.setUserName(user.getUserName());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        u.setBalance(user.getBalance());
        userRepostiry.save(u);
        return true;
    }

    public boolean deleteUser(Integer id){
        User u = userRepostiry.getById(id);
        if(u == null){
            return false;
        }
        userRepostiry.deleteById(id);
        return true;
    }
}
