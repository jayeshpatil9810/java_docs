package poc.example.wishlist_module.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import poc.example.wishlist_module.entity.Product;

@FeignClient(url="http://localhost:8082",value="product-module")
public interface APIClient {
	
	@GetMapping("/api/product")
    public List<Product> getAllProducts();
	

}
