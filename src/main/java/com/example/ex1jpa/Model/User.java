package com.example.ex1jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="User name must not be empty")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    @Size(min=6,message="The length of user name must be more than 5")
    @Column(columnDefinition = "varchar(50) not null")
    private String userName;

    @NotEmpty(message = "Password must not be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,}$")
    @Column(columnDefinition = "varchar(50) unique not null ")
    private String password;

    @NotEmpty(message="Email must not be empty")
    @Email
    @Column(columnDefinition = " varchar(30) unique not null")
    private String email;

    @NotEmpty(message="Role must not be empty")
    @Pattern(regexp="^(Admin|Customer)$",message = "Only 2 options(Admin or Customer)")
   // @Column(columnDefinition = "varchar(10) check (role = 'Admin' or role = 'Customer' )")
    private String role;

    @NotNull(message="Balance must not be empty")
    @Positive(message="Balance should be a positive number")
    @Column(columnDefinition = "int not null")
    private int balance;
}
