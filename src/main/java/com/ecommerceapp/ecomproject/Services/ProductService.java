package com.ecommerceapp.ecomproject.Services;

import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService  {
    public Product getSingleProduct(int id) throws ProductNotFoundException;
    public List<Product> getAllProductsByCategoty(String cattitle);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(int id) throws ProductNotFoundException;
    public Product UpdateProduct(String title,Product product) throws ProductNotFoundException;
    public Page<Product> getAllProducts(int pagesize,int pagenumber,String feild);
}
