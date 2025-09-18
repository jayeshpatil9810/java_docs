package com.v2.search_module_updated.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2.search_module_updated.entity.SearchEntity;
import com.v2.search_module_updated.service.SearchService;

@RestController
@RequestMapping("/searchmodule/products")
public class SearchController {
	@Autowired
	private SearchService searchService;

	@GetMapping("/search")
	public ResponseEntity<List<SearchEntity>> searchProducts(@RequestParam("search") String search) {
		return ResponseEntity.ok(searchService.searchProducts(search));
	}
	
	@PostMapping
    public SearchEntity createProduct(@RequestBody SearchEntity product){
        return searchService.createProduct(product);
    }

	
	
	
}
