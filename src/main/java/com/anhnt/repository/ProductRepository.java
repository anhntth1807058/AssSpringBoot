package com.anhnt.repository;

import com.anhnt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> , JpaRepository<Product, Integer> {
}
