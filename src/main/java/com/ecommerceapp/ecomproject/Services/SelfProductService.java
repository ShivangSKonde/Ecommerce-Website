package com.ecommerceapp.ecomproject.Services;

import com.ecommerceapp.ecomproject.Models.Category;
import com.ecommerceapp.ecomproject.Models.Product;
import com.ecommerceapp.ecomproject.exceptions.ProductNotFoundException;
import com.ecommerceapp.ecomproject.repositories.CategoryRepository;
import com.ecommerceapp.ecomproject.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(int id) throws ProductNotFoundException {
        Product product= productRepository.findById(id);
        if(product==null)
        {
            throw new ProductNotFoundException("Product not found with id: "+id);
        }
        return product;
    }

    @Override
    public List<Product> getAllProductsByCategoty(String cattitle) {
        //get the id of a category title
        //List<Product>=productRepository.findAll()
        Category c=categoryRepository.findByTitle(cattitle);
        int k=c.getId();
        List<Product> l=productRepository.FindByCategoryId(k);
        return l;
    }

    @Override
    public Product createProduct(Product product) {
        //Category c=product.getCategory();
        Category exist=categoryRepository.findByTitle(product.getCategory().getTitle());
        if(exist==null)
        {
            categoryRepository.save(product.getCategory());
        }
        else{
            product.setCategory(exist);
        }
        Product product1= productRepository.save(product);
        return product1;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) throws ProductNotFoundException {
        Product product=productRepository.findById(id);
        if(product==null)
        {
            throw new ProductNotFoundException("Product not found with id: "+id);
        }
        productRepository.deleteById(id);

    }

    @Override
    public Product UpdateProduct(String title, Product product) throws ProductNotFoundException{
        Product product1=productRepository.findByTitle(title);
        if(product1==null)
        {
            throw new ProductNotFoundException("Product not found with title: "+title);
        }
        else{
            product1.setTitle(product.getTitle());
            product1.setPrice(product.getPrice());
            product1.setImageurl(product.getImageurl());
            product1.setDescription(product.getDescription());

            Category c=categoryRepository.findByTitle(product.getCategory().getTitle());
            if(c==null)
            {
                categoryRepository.save(product.getCategory());
            }
            else{
                product1.setCategory(c);
            }
            productRepository.save(product1);
        }
        return product1;
    }

    @Override
    public Page<Product> getAllProducts(int pagesize, int pagenumber ,String feild) {
        Page<Product> allprod=productRepository.findAll(PageRequest.of(pagenumber,pagesize, Sort.by(feild).ascending()));
        return allprod;
    }


}
