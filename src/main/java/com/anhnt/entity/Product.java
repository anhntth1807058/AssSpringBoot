package com.anhnt.entity;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "categoryid", insertable = false, updatable = false)
    private Integer categoryid;

    @Column(name = "price")
    private Integer price;

    @ManyToOne() //EAGER
    @JoinColumn(name = "categoryid")
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, Integer categoryid, Integer price, Category category) {
        this.id = id;
        this.name = name;
        this.categoryid = categoryid;
        this.price = price;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}