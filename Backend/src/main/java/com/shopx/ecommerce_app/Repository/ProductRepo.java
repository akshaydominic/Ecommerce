package com.shopx.ecommerce_app.Repository;

import com.shopx.ecommerce_app.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long>{
    
}