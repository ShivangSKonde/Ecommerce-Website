package com.ecommerceapp.ecomproject.Controller;

import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.Services.FakeStoreProductService;
import com.ecommerceapp.ecomproject.Services.ProductService;
import com.ecommerceapp.ecomproject.dtos.ErrorMessage;
import com.ecommerceapp.ecomproject.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    ProductService productService;

    //dependency injection of service now we can use Productservice object in ProductController
    public  ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/product/{id}")
   public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id) throws Exception {
        Product product=productService.getSingleProduct(id);
        ResponseEntity<Product> res=new ResponseEntity<>(product,HttpStatus.OK);
        return res;
   }

   @ExceptionHandler(ProductNotFoundException.class)
   public ResponseEntity<ErrorMessage> handleProductNotFoundException(Exception ex){
       ErrorMessage errorMessage=new ErrorMessage();
       errorMessage.setMessage(ex.getMessage());
       //ResponseEntity<ErrorMessage> ResponseEntity;
       return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
   }

   @PostMapping("/product")
   public Product createProduct(@RequestBody Product product)
   {
        Product newProduct=productService.createProduct(product);
        return newProduct;
   }
}
