package com.mvc.productcategory.repository;

import com.mvc.productcategory.models.Category;
import com.mvc.productcategory.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Long> {
    List<Category> findAll();
    Category findCategoryById(Long id);
    List<Category> findByProductsNotContains(Product p);
    List<Category> findByProductsContains(Product p);
}
