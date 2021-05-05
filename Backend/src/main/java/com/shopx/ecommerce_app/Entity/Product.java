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




@Entity
@Table(name="product")

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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ProductCategory getCategory() {
        return category;
    }
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getUnitprice() {
        return unitprice;
    }
    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public int getUnitsinstock() {
        return unitsinstock;
    }
    public void setUnitsinstock(int unitsinstock) {
        this.unitsinstock = unitsinstock;
    }
    public Date getDatecreated() {
        return datecreated;
    }
    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }
    public Date getLastupdated() {
        return lastupdated;
    }
    public void setLastupdated(Date lastupdated) {
        this.lastupdated = lastupdated;
    }

    

    
}