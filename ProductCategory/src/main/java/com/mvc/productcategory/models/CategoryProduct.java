package com.mvc.productcategory.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="categories_products")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public CategoryProduct() {

    }

    public CategoryProduct(Product product, Category category) {
        this.product = product;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public Long getId() {
        return id;
    }
    public Product getProduct() {
        return product;
    }

    public Category getCategory() {
        return category;
    }
}