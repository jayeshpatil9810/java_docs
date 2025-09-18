package poc.example.wishlist_module.Controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.example.wishlist_module.entity.WishListDetails;
import poc.example.wishlist_module.entity.WishListResponse;
import poc.example.wishlist_module.entity.Wishlist;
import poc.example.wishlist_module.service.Wishlistservice;

@RestController
@RequestMapping("/api/wishlist")
public class Wishlistcontroller {
	
	@Autowired
	private Wishlistservice wishlistservice;
	
	
	@PostMapping
	public ResponseEntity<Object> addwishlist(@RequestBody Wishlist product, Principal principal) {
	    
	        WishListResponse wishListResponse = wishlistservice.addProduct(product,principal);
	        WishListDetails wishListDetails = new WishListDetails();
	        wishListDetails.setStatusCode("2001");
	        wishListDetails.setDescription("Wishlist product added successfully");
	        wishListDetails.setWishListResponse(wishListResponse);
	        return new ResponseEntity<>(wishListDetails, HttpStatus.CREATED);  
	}
	
	
	@GetMapping("/{wishlistId}")
	public ResponseEntity<WishListResponse> getProductById(@PathVariable Long wishlistId) {
	    WishListResponse productById = wishlistservice.getProductById(wishlistId);
	    return ResponseEntity.ok(productById);
	}
    
   
	@GetMapping("/product")
	public ResponseEntity<List<Wishlist>> getProductsByUserId(Principal principal) {
	    List<Wishlist> products = wishlistservice.getProductsByUserId(principal);
	    return ResponseEntity.ok(products);
	}
	
    
	@DeleteMapping("/{productId}")
	public ResponseEntity<Object> deleteFromWishlist(@PathVariable Long productId, Principal principal) {
	    wishlistservice.deleteFromWishlist(productId);
	    Map<String, Object> responseMap = new LinkedHashMap<>();
	    responseMap.put("description", "Product deleted successfully");
	    responseMap.put("appStatusCode", "2000");
	    
	    return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}
	
}
	
	
	
	
