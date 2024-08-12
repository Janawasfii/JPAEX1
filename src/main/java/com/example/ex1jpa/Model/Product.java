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
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Product name must not be empty")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    @Size(min=4,message="The length of product must be more than 3")
    @Column(columnDefinition = "varchar(50) not null")
    private String productName;

    @NotNull(message="Product price should not be empty")
    @Positive(message="Product price must be positive number")
    @Column(columnDefinition = "int not null")
    private int productPrice;

    @NotNull(message="Category ID must not be empty")
    @Column(columnDefinition = "int not null unique")
    //@Pattern(regexp = "^\\d{3}$")
    private Integer categoryID;

//    @NotNull(message="User ID must not be empty")
//    @Column(columnDefinition = "int not null unique")
//    private Integer userID;
}
