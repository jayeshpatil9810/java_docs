package com.v2.springbootproduct.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.v2.springbootproduct.entity.Product;
import com.v2.springbootproduct.exception.ResourceNotFoundException;
import com.v2.springbootproduct.payload.ProductDto;
import com.v2.springbootproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		Product savedProduct= productRepo.save(product);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productRepo.findAll();
		return products.stream().map((product)-> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Product getProductById(Long id) {
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
       return modelMapper.map(product, Product.class);
	}

	@Override
	public ProductDto updateProduct(Long id, ProductDto productDto) {
		Product updateProduct = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		updateProduct.setName(productDto.getName());
		updateProduct.setDescription(productDto.getDescription());
		updateProduct.setPrice(productDto.getPrice());
		updateProduct.setCategory(productDto.getCategory());
		 Product updatedProduct = productRepo.save(updateProduct);
		 return modelMapper.map(updatedProduct, ProductDto.class);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		productRepo.deleteById(id);
	}

	@Override
	public ProductDto getProductByName(String name) {
		Optional<Product> productOptional = productRepo.findByName(name);
		Product products = productOptional.orElseThrow(() -> new NoSuchElementException("Product not found"));
		return modelMapper.map(products, ProductDto.class);
	}

	
	@Override
	public List<ProductDto> getProductsByCategory(String category) {
		List<Product> findByCategory = productRepo.findByCategory(category);
		return findByCategory.stream().map((product)-> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> searchProduct(String search) {
		return productRepo.findByNameContainingOrDescriptionContainingOrCategoryContaining(search, search, search);		
	}
}
