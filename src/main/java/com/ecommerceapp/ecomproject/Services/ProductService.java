package com.ecommerceapp.ecomproject.Services;

import com.ecommerceapp.ecomproject.Models.Product;

import java.util.List;

public interface ProductService  {
    public Product getSingleProduct(int id) throws Exception;
    public List<Product> getAllProducts();
    public Product createProduct(Product product);
}
