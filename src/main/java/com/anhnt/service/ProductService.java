package com.anhnt.service;

import com.anhnt.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product create (Product product);
    Product update (Product product);
}