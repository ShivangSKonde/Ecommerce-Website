package com.ecommerceapp.ecomproject;


import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.repositories.CategoryRepository;
import com.ecommerceapp.ecomproject.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EcomProjectApplicationTests {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public EcomProjectApplicationTests(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Test
    void contextLoads() {

//        List<Product> products = productRepository.FindByCategoryId(2)
//       System.out.println(products.get(0));
    }

}
