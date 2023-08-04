package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
