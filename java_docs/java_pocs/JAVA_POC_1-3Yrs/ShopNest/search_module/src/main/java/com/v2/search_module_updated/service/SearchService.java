package com.v2.search_module_updated.service;

import java.util.List;

import com.v2.search_module_updated.entity.SearchEntity;

public interface SearchService {

	List<SearchEntity> searchProducts(String search);

	SearchEntity createProduct(SearchEntity product);

}
