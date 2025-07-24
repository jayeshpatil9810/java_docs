package com.v2.springbootproduct.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.payload.ProductDto;
import com.v2.springbootproduct.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
		ProductDto addProduct = productService.addProduct(productDto);
		LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
		map.put("appStatusCode", "2001");
		map.put("description", "Product Added Successfully!");
		map.put("productDetails", addProduct);
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> allProducts = productService.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@GetMapping("/getid/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product productById = productService.getProductById(id);
		return new ResponseEntity<>(productById, HttpStatus.OK);
	}

	@GetMapping("/getname/{name}")
	public ResponseEntity<ProductDto> getProductByname(@PathVariable String name) {
		ProductDto productByName = productService.getProductByName(name);
		return new ResponseEntity<ProductDto>(productByName, HttpStatus.OK);
	}

	@GetMapping("/getcategory/{category}")
	public ResponseEntity<List<ProductDto>> getProductsByCategory(@PathVariable String category) {
		List<ProductDto> productsByCategory = productService.getProductsByCategory(category);
		return ResponseEntity.ok(productsByCategory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
		ProductDto updateProduct = productService.updateProduct(id, productDto);
		LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
		map.put("appStatusCode", "2000");
		map.put("description", "Product Updated Successfully!");
		map.put("productDetails", updateProduct);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
		map.put("appStatusCode", "2000");
		map.put("description", "Product Deleted Successfully!");
		return new ResponseEntity<>(map, HttpStatus.OK);

	}
}