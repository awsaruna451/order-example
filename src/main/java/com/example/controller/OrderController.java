package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.ProductDto;
import com.example.dto.OrderRequest;
import com.example.dto.User;
import com.example.model.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createProduct(HttpServletRequest request, @RequestParam OrderRequest orderRequest) {

               List<Order> response = orderService.getOrdersByUserIds(orderRequest);
        return ResponseEntity.ok(new ApiResponse(true, response));
    }
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getProduct(HttpServletRequest request) {
        String id = "arunas8@gmail.com";
        String uri = "http://SPRING-API-GATEWAY/api/user?userName="+id;
        ResponseEntity<User> user = restTemplate.getForEntity(uri, User.class);

        return ResponseEntity.ok(new ApiResponse(true, user.getBody()));
    }
}
