package com.example.service;

import com.example.dto.ProductDto;
import com.example.dto.OrderRequest;
import com.example.model.Order;
import com.example.model.Product;
import com.example.repository.OrderRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUserIds(OrderRequest orderRequest) {
       return orderRepository.findByUserIdIn(orderRequest.getUserId());
    }
}
