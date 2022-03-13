package com.example.service;

import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDto saveProduct(ProductDto productDto) {
       Product product = productRepository.save(new Product(productDto));
       return new ProductDto(product);
    }
    public List<Product> getProducts() {
       return productRepository.findAll();
    }
}
