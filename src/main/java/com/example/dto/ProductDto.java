package com.example.dto;

import com.example.model.Product;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {
    private int id;
    private String productName;
    private int quantity;
    private BigDecimal price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.productName =  product.getProductName();
        this.quantity = product.getQuantity();
        this.price = new BigDecimal(product.getPrice());

    }
}
