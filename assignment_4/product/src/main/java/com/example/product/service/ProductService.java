package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import org.springframework.stereotype.Service;
import com.example.product.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Laptop", 75000.0));
        products.add(new Product(2L, "Phone", 30000.0));
        products.add(new Product(3L, "Keyboard", 2000.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product addProduct(ProductDTO productDTO) {
        Long newId = (long) (products.size() + 1);

        Product product = new Product(newId, productDTO.getName(), productDTO.getPrice());
        products.add(product);

        return product;
    }
}
