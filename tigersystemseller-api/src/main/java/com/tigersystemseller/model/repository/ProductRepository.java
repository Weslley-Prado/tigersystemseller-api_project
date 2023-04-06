package com.tigersystemseller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tigersystemseller.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
