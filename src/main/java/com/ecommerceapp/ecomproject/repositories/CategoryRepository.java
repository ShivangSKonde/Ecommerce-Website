package com.ecommerceapp.ecomproject.repositories;

import com.ecommerceapp.ecomproject.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByTitle(String title);
    Category findById(int id);
}
