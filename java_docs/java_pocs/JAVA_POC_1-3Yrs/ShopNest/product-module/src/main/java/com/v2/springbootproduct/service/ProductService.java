package com.v2.springbootproduct.service;

import java.util.List;


import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.payload.ProductDto;

public interface ProductService {
 public ProductDto addProduct(ProductDto productDto);
 public List<ProductDto> getAllProducts();
 public Product getProductById(Long id);
 public ProductDto getProductByName(String name);
 public ProductDto updateProduct(Long id,ProductDto updatedProductDto);
 public void deleteProduct(Long id);
 
 
 public List<ProductDto> getProductsByCategory(String category);
public List<Product> searchProduct(String search);
}
