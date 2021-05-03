package com.shopx.ecommerce_app.Repository;

import com.shopx.ecommerce_app.Entity.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory",path = "product-category")
public interface ProductCategoryRepo extends JpaRepository<ProductCategory,Long>{
    
}