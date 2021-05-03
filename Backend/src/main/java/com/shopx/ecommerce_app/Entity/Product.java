package com.shopx.ecommerce_app.Entity;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory category;

    @Column(name="sku")
    private String sku;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="unit_price")
    private BigDecimal unitprice;
    @Column(name="image_url")
    private String imageurl;
    @Column(name="active")
    private boolean active;
    @Column(name="units_in_stock")
    private int unitsinstock;
    @Column(name="date_created")
    @CreationTimestamp
    private Date datecreated;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastupdated;

    
}