package com.shopx.ecommerce_app.Config;

import com.shopx.ecommerce_app.Entity.Product;
import com.shopx.ecommerce_app.Entity.ProductCategory;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        
        HttpMethod[] unsportedmethods ={HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
        //disable http method post put delete for product class
        config.getExposureConfiguration()
        .forDomainType(Product.class)
        .withItemExposure((metadata,httpMethods)->httpMethods.disable(unsportedmethods))
        .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(unsportedmethods));
        //disable http method post put delete for product_category class
        config.getExposureConfiguration()
        .forDomainType(ProductCategory.class)
        .withItemExposure((metadata,httpMethods)->httpMethods.disable(unsportedmethods))
        .withCollectionExposure((metadata,httpMethods)->httpMethods.disable(unsportedmethods));
    }
}