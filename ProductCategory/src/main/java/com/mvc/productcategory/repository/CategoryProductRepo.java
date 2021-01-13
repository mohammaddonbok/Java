package com.mvc.productcategory.repository;

import com.mvc.productcategory.models.CategoryProduct;
import com.mvc.productcategory.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepo extends CrudRepository<CategoryProduct,Long> {

}
