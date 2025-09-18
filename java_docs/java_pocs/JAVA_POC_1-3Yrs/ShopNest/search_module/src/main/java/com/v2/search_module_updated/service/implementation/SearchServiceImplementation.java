package com.v2.search_module_updated.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2.search_module_updated.entity.SearchEntity;
import com.v2.search_module_updated.repository.SearchRepository;
import com.v2.search_module_updated.service.SearchService;

@Service
public class SearchServiceImplementation implements SearchService {
	
	@Autowired
	private SearchRepository searchRepository;

	@Override
	public List<SearchEntity> searchProducts(String search) {
		return searchRepository.findByProductNameContainingOrDescriptionContaining(search, search);
	}

	@Override
	public SearchEntity createProduct(SearchEntity product) {
		return searchRepository.save(product);
		
	}

}
