package com.v2.search_module_updated.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2.search_module_updated.entity.SearchEntity;

public interface SearchRepository extends JpaRepository<SearchEntity, Long> {
	List<SearchEntity> findByProductNameContainingOrDescriptionContaining(String search, String keyword);

}
