package com.ecommerceapp.ecomproject.Controller;

import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.Services.FakeStoreProductService;
import com.ecommerceapp.ecomproject.Services.ProductService;
import com.ecommerceapp.ecomproject.dtos.DeletionMessageDto;
import com.ecommerceapp.ecomproject.dtos.ErrorMessage;
import com.ecommerceapp.ecomproject.exceptions.ProductNotFoundException;
import com.ecommerceapp.ecomproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    //dependency injection of service now we can use Productservice object in ProductController
    public  ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/product/{id}")
   public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product product=productService.getSingleProduct(id);
        ResponseEntity<Product> res=new ResponseEntity<>(product,HttpStatus.OK);
        return res;
   }


   @PostMapping("/product")
   public Product createProduct(@RequestBody Product product)
   {
        Product newProduct=productService.createProduct(product);
        return newProduct;
   }

   @GetMapping("/products/{title}")
   public List<Product> getProductsByTitle(@PathVariable("title") String title)
   {
       List<Product> ls=productService.getAllProducts(title);
       return ls;
   }

   @DeleteMapping("/product/{id}")
    public ResponseEntity<DeletionMessageDto> deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException {
       productService.deleteProduct(id);
       DeletionMessageDto deletionMessageDto=new DeletionMessageDto();
       deletionMessageDto.setMessage("Product deleted successfully");
       return new ResponseEntity<>(deletionMessageDto, HttpStatus.OK);
   }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleProductNotFoundException(Exception ex){
        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        //ResponseEntity<ErrorMessage> ResponseEntity;
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
