package com.ecommerceapp.ecomproject.Services;

import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService  {
    public Product getSingleProduct(int id) throws ProductNotFoundException;
    public List<Product> getAllProducts(String cattitle);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int id) throws ProductNotFoundException;
}
