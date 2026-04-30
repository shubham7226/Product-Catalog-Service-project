package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.dto.ReviewDTO;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.model.Product;
import com.example.product.model.Review;
import com.example.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        for (ReviewDTO reviewDTO : productDTO.getReviews()) {
            Review review = new Review();
            review.setComment(reviewDTO.getComment());
            review.setProduct(product);
            product.getReviews().add(review);
        }

        return productRepository.save(product);
    }
}
