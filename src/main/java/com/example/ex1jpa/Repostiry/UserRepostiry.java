package com.example.ex1jpa.Repostiry;

import com.example.ex1jpa.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepostiry extends JpaRepository<User,Integer> {
}
