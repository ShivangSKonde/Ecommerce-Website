package com.ecommerceapp.ecomproject.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.Lombok;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
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
    private String description;
    private String imageurl;
    private double price;
    private Category category;


}
