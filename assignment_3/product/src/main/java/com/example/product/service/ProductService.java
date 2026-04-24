package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        return List.of(
                new Product(1L, "Laptop", 75000.0),
                new Product(2L, "Phone", 30000.0),
                new Product(3L, "Keyboard", 2000.0)
        );
    }
}
