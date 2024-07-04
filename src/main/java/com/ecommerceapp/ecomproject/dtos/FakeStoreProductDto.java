package com.ecommerceapp.ecomproject.dtos;

import com.ecommerceapp.ecomproject.Models.Category;
import com.ecommerceapp.ecomproject.Models.Product;
//import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter

public class FakeStoreProductDto {
    //{
//        id:1,
//            title:'...',
//            price:'...',
//            category:'...',
//            description:'...',
//            image:'...'
//    },
    private int id;
    private String title;
    private double Price;
    private String catg;
    private String description;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setPrice(Price);
        product.setDescription(description);
        product.setImageurl(image);
        product.setTitle(title);

        Category category = new Category();
        category.setTitle(catg);
        product.setCategory(category);
        return product;
    }

}
