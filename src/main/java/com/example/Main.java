package com.example;

import com.example.productservice.model.Product;

public class Main {

    public static void main(String[] args) {

        Product product = new Product(1L, "Laptop", 75000.0);

        System.out.println("Product Name: " + product.getName());
    }
}