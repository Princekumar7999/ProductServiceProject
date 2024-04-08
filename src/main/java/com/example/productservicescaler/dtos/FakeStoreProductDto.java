package com.example.productservicescaler.dtos;

//package com.example.productservicescaler.dtos;

import com.example.productservicescaler.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String image;

}
