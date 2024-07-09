package com.ecommerceapp.ecomproject.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.Lombok;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product extends BaseModel {
    //{
//        id:1,
//            title:'...',
//            price:'...',
//            category:'...',
//            description:'...',
//            image:'...'
//    },

    private String title;
    private String description;
    private String imageurl;
    private double price;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;


}
