package com.example.ex1jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name="merchantStock")
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message=" Product ID must not be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer productID;

    @NotNull(message="Merchant ID must not be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer merchantID;

    @NotNull(message="Stock must not be empty")
    @Min(11)
    @Column(columnDefinition = "int not null ")
    private int stock;
}
