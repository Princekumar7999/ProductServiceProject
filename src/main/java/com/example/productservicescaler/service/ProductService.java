package com.example.productservicescaler.service;

//package com.example.productservicescaler.service;

import com.example.productservicescaler.exceptions.ProductNotFoundException;
import com.example.productservicescaler.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();

}
