package com.mvc.productcategory.services;

import com.mvc.productcategory.models.Category;
import com.mvc.productcategory.models.CategoryProduct;
import com.mvc.productcategory.models.Product;
import com.mvc.productcategory.repository.CategoryProductRepo;
import com.mvc.productcategory.repository.CategoryRepo;
import com.mvc.productcategory.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProCatService {
    private final CategoryRepo catRepo;
    private final ProductRepo proRepo;
    private final CategoryProductRepo catProRepo;

    public ProCatService(CategoryRepo catRepo, ProductRepo proRepo, CategoryProductRepo catProRepo) {
        this.catRepo = catRepo;
        this.proRepo = proRepo;
        this.catProRepo = catProRepo;
    }
    public List<Product> allProducts(){
        return proRepo.findAll();
    }
    public List<Category> allCategories(){
        return catRepo.findAll();
    }
    public Product creatProduct(Product p){
        return proRepo.save(p);
    }
public Category createCategory(Category c){
        return catRepo.save(c);
}
public Product getProduct(Long id){

        return proRepo.findProductById(id);
}
    public Category getCategory(Long id){

        return catRepo.findCategoryById(id);
    }
    public CategoryProduct createAssociation(CategoryProduct cp){

     return catProRepo.save(cp);
}
public CategoryProduct addProdToCategory(CategoryProduct cp){
        return catProRepo.save(cp);
}

    public CategoryProduct creatProCat(CategoryProduct catpro){
        return this.catProRepo.save(catpro);
    }
    public List<Category>categoriesAssociated(Product p){
        return catRepo.findByProductsContains(p);
    }
    public List<Category> categoriesNotAssociated(Product p){
        return catRepo.findByProductsNotContains(p);
    }
    public List<Product> productAssociate(Category c){
        return proRepo.findByCategoriesContains(c);
    }
    public List<Product> productNotAssociate(Category c){
        return proRepo.findByCategoriesNotContains(c);
    }

//    public Product createProduct(Product prod) {
//    }
}
