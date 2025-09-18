package com.v2.springbootproduct.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2.springbootproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String name);
    List<Product> findByCategory(String category);
    List<Product> findByNameContainingOrDescriptionContainingOrCategoryContaining(String search, String keyword, String category);
}
