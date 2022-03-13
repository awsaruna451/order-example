package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.OrderRequest;
import com.example.dto.ProductDto;
import com.example.model.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createProduct(HttpServletRequest request, @RequestParam OrderRequest orderRequest) {
        List<Order> response = orderService.getOrdersByUserIds(orderRequest);
        return ResponseEntity.ok(new ApiResponse(true, response));
    }
}
