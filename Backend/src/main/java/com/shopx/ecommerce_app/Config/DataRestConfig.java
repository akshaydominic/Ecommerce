package com.shopx.ecommerce_app.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import com.shopx.ecommerce_app.Entity.Product;
import com.shopx.ecommerce_app.Entity.ProductCategory;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

    private EntityManager entityManager;

    public DataRestConfig(EntityManager theeEntityManager){
        this.entityManager = theeEntityManager;
    }

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
        //call an internal helper method
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClass = new ArrayList<>();

        for(EntityType tempEntityType : entities){
            entityClass.add(tempEntityType.getJavaType());
        }

        Class[] domainTypes = entityClass.toArray(new Class[0]);

        config.exposeIdsFor(domainTypes);
        
        

    }
}