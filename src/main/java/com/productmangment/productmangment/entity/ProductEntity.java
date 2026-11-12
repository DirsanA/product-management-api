package com.productmangment.productmangment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "Product name is required")
    private  String name;

    @NotBlank(message = "description is required")
    @Column(nullable = false)
    private  String desc;

    @NotBlank(message = "Price is required")
    @Column(nullable = false)
    @DecimalMin("0.01")
    private BigDecimal price;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private int quantity;

}
