package com.mvc.productcategory.repository;

import com.mvc.productcategory.models.Category;
import com.mvc.productcategory.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<Product,Long> {
    List<Product> findAll();
    Product findProductById(Long id);
List<Product>findByCategoriesContains(Category c);
    List<Product>findByCategoriesNotContains(Category c);
}
