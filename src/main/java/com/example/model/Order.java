package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "order_quantity")
    private int orderQuantity;
    @Column(name = "order_amount")
    private float orderAmount;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp createdDate;
    @Column(name = "update_date", nullable = false, updatable = false)
    @CreatedDate
    private Timestamp updatedDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
}
