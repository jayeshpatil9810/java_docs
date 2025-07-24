package com.v2.springbootproduct.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.exception.ProductNotFoundException;
import com.v2.springbootproduct.service.ProductService;

/*
 * All the controllers are listed below:
 * 1. searchProducts(Searches product by name) (GET) (/api/search?search={search})
 */

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    ProductService productService;
    
    /*
     * Added paging support with default page size as 10 and page number as 0
     */
    
    @GetMapping
    public ResponseEntity<Object> searchProducts(@RequestParam("search") String search){
        List<Product> searchResults =  productService.searchProduct(search);
        if(!searchResults.isEmpty()){
            HashMap<Object, Object> response = new HashMap<>();
            response.put("appStatusCode: ", "2000");
            response.put("description: ", "Product found successfully");
            response.put("product: ", searchResults);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new ProductNotFoundException("No product match with query " + search, HttpStatus.NOT_FOUND);
        }
        
    }


    // @GetMapping
    // public ResponseEntity<Object> searchProducts(@RequestParam("search") String search,
    //                                                     @RequestParam(value = "page", defaultValue = "0", required = false) int page,
    //                                                     @RequestParam(value = "size", defaultValue = "10", required = false) int size){
    //     Pageable pageable = PageRequest.of(page, size);
    //     System.out.println(pageable);
    //     Page<Product> searchResults = productService.searchProduct(search, pageable);
    //     System.out.println(searchResults);
    //     if(!searchResults.isEmpty()){
    //         HashMap<Object, Object> response = new HashMap<>();
    //         response.put("appStatusCode: ", "2001");
    //         response.put("description: ", "Product found successfully");
    //         response.put("product: ", searchResults.getContent());
    //         return new ResponseEntity<>(response, HttpStatus.OK);
    //     } else {
    //         throw new ProductNotFoundException("No product match with query " + search, HttpStatus.NOT_FOUND);
    //     }
        
    // }
}
