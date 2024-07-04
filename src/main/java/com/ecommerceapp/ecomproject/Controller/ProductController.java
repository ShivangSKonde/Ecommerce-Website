package com.ecommerceapp.ecomproject.Controller;

import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.Services.FakeStoreProductService;
import com.ecommerceapp.ecomproject.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    ProductService productService;

    //dependency injection of service now we can use Productservice object in ProductController
    public  ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/product/{id}")
   public Product getSingleProduct(@PathVariable("id") int id){
        Product product=productService.getSingleProduct(id);
        return product;
   }

   @PostMapping("/product")
   public Product createProduct(@RequestBody Product product)
   {
        Product newProduct=productService.createProduct(product);
        return newProduct;
   }
}
