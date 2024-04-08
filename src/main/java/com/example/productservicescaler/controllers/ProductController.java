package com.example.productservicescaler.controllers;



import com.example.productservicescaler.ProductServiceScalerApplication;
import com.example.productservicescaler.dtos.ExceptionDto;
import com.example.productservicescaler.dtos.FakeStoreProductDto;
import com.example.productservicescaler.exceptions.ProductNotFoundException;
import com.example.productservicescaler.models.Product;
import com.example.productservicescaler.service.FakeStoreProductService;
import com.example.productservicescaler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.InputMismatchException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //    private final ProductServiceScalerApplication productServiceScalerApplication ;
//    private FakeStoreProductService fakeStoreProductService;
    private ProductService productServicervice;

//  e
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productServicervice = productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productServicervice.getProductById(id);
        ResponseEntity<Product> responseEntity;
//        if (product == null) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return responseEntity;
//        }

//        Product sampleProduct = new Product();

        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;

//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (ArithmeticException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        //Controllers should be as light as possible.
//        return responseEntity;
        //throw new RuntimeException("Something went wrong");
    }

    //
    @GetMapping()
    public List<Product> getAllProducts() {
        return productServicervice.getAllProducts();
    }
}

