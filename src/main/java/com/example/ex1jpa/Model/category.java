package com.example.ex1jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="categories")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message="Category name must not be empty")
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
    @Size(min=4,message="The length of category name must be more than 3")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String CategoryName;

}
