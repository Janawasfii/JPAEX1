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
@Table(name="merchant")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message ="Merchant name must not be empty")
    @Size(min=4,message="The length of merchant name must be more than 3")
    @Column(columnDefinition = "varchar(30) not null ")
    private String merchantName;
    @NotEmpty(message="Status should not be empty")
    @Pattern(regexp="^(PLACED|PROCESSING|SHIPPED|DELIVERED)$",message = "Only 4 options(PLACED or PROCESSING or SHIPPED or DELIVERED)")
    //@Column(columnDefinition = "varchar(10) check (merchant='PLACED' or merchant ='PROCESSING' or merchant ='SHIPPED' or merchant ='DELIVERED' )")
    private String status;
    @NotNull(message="Order ID must not be empty")
    @Column(columnDefinition ="int not null unique" )
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
}
