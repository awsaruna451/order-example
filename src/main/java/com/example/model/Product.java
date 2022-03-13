package com.example.model;

import com.example.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "product_name")
    private String productName;
    private int quantity;
    private float price;
    @Column(name = "created_date", updatable = false)
    @CreatedDate
    private Timestamp createdDate;
    @Column(name = "update_date", updatable = false)
    @CreatedDate
    private Timestamp updatedDate;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
    private List<Order> orders;

    public Product(ProductDto productDto) {
        this.id = productDto.getId();
        this.productName =  productDto.getProductName();
        this.quantity =  productDto.getQuantity();
        this.price = productDto.getPrice().floatValue();
    }
}
