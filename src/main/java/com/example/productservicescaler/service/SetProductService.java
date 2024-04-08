package com.example.productservicescaler.service;

import com.example.productservicescaler.exceptions.ProductNotFoundException;
import com.example.productservicescaler.models.Product;

import java.util.List;

public class SetProductService implements ProductService {
    private ProductRepository productRepository;
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }



}
