package com.example.productservice.service;

import com.example.productservice.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Laptop", 75000.0));
        products.add(new Product(2L, "Smartphone", 35000.0));
        products.add(new Product(3L, "Headphones", 5000.0));
        products.add(new Product(4L, "Keyboard", 2500.0));
        products.add(new Product(5L, "Monitor", 18000.0));
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsAbovePrice(double price) {
        return products.stream()
                .filter(product -> product.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<String> getProductNames() {
        return products.stream()
                .map(product -> Optional.ofNullable(product)
                        .map(Product::getName)
                        .orElse("Unknown Product"))
                .collect(Collectors.toList());
    }
}
