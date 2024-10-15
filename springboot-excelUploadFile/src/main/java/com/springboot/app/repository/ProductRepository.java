package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{


}
