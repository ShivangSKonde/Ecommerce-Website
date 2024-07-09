package com.ecommerceapp.ecomproject.repositories;

import com.ecommerceapp.ecomproject.Models.Category;
import com.ecommerceapp.ecomproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> //<Entity class,primary key type-use genrecis>
{

    Product save(Product product);  // used for post request
    Product findByTitle(String title);
    Product findByDescription(String description);
    Product findById(int id); //used for get request
    List<Product> findByCategory(Category category);
    void deleteById(int id);

    // HQL query
    @Query("select p from Product p where p.category.id= :id")
    List<Product> FindByCategoryId(@Param("id") int id);

    //  Native Query
//    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
//    List<Product> getProductsByCategoryIdWithNativeQueries(@Param("categoryId") Long categoryId);
}
