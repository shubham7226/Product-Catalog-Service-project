package com.example;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        double minimumPrice = 10000.0;

        System.out.println("All Products:");
        for (Product product : productService.getProducts()) {
            System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
        }

        System.out.println();
        System.out.println("Products Above Price " + minimumPrice + ":");
        for (Product product : productService.getProductsAbovePrice(minimumPrice)) {
            System.out.println("Product Name: " + product.getName() + ", Price: " + product.getPrice());
        }

        System.out.println();
        System.out.println("Product Names:");
        for (String productName : productService.getProductNames()) {
            System.out.println(productName);
        }
    }
}
