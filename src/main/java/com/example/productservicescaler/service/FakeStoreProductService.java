package com.example.productservicescaler.service;

//package com.example.productservicescaler.service;

import com.example.productservicescaler.dtos.FakeStoreProductDto;
import com.example.productservicescaler.exceptions.ProductNotFoundException;
import com.example.productservicescaler.models.Category;
import com.example.productservicescaler.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate = new RestTemplate();

    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setTitle(dto.getCategory());
        product.setCategory(category);

        return product;
    }

//    @Override
//    public Product getProductById(Long Id, FakeStoreProductDto RestTemplate) {
//        return null;
//    }

    //    @Override
//    public Product getProductById(Long Id, com.example.productservicescaler.dtos.FakeStoreProductDto RestTemplate) {
//        throw new RuntimeException("something went wrong in service");
//
//
//        RestOperations restTemplate;
//        restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//        boolean fakeStoreProductDto;
//        if(fakeStoreProductDto == null) {
//            throw new ProductNotFoundException("Please pass a  valid product id");
//        }
//        Product product = new Product();
//        product.setId(FakeStoreProductDto.getId());
//        product.setTitle(FakeStoreProductDto.getTitle());
//        product.setDescription(FakeStoreProductDto.getDescription());
//        product.setImage(FakeStoreProductDto.getImage());
//        Category category = new Category();
//        //category.setDescription(fakeStoreProductDto);
//        product.setCategory(category);
//        return product;
//    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException{
        //Call FakeStore API here to get the Product with given id.

        FakeStoreProductDto fakeStoreProductDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);
        //1st param -> URL
        //2nd param -> Response

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Product with id " + id + " not found");
            //return null;
        }

        //Convert FakeStore DTO into Product object.
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        Class<FakeStoreProductDto> List;
        List<FakeStoreProductDto> fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products", List.class);
        Object o = new Object();
        List list = new ArrayList();

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {

            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));

        }
        return products;

    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}

