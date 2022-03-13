package com.example.controller;

import com.example.dto.ApiResponse;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ApiResponse> createProduct(HttpServletRequest request, @RequestBody ProductDto product) {
        ProductDto response = productService.saveProduct(product);
        return ResponseEntity.ok(new ApiResponse(true, response));
    }

    @GetMapping("/product")
    public ResponseEntity<ApiResponse> getProducts(HttpServletRequest request) {
        List<Product> response = productService.getProducts();
        return ResponseEntity.ok(new ApiResponse(true, response));
    }
}
