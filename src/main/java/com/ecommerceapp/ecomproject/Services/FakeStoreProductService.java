package com.ecommerceapp.ecomproject.Services;

import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.dtos.FakeStoreProductDto;
import com.ecommerceapp.ecomproject.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(int id) throws ProductNotFoundException{
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null) {
             throw new ProductNotFoundException("Product not found with id"+id);
        }
        return fakeStoreProductDto.toProduct();

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        // we are getting Product, but we have to convert it to FakeStoreProductDto
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageurl());
        fakeStoreProductDto.setCatg(product.getCategory().getTitle());

        //send this fakeStoreProductDto to fakestore, and it will reply back with new id and all details you have mentoioned
        FakeStoreProductDto fsProductDto = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);
        return fsProductDto.toProduct();
    }
}
