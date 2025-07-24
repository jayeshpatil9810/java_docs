package poc.example.wishlist_module.service;

import java.security.Principal;
import java.util.List;               

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import poc.example.wishlist_module.Repository.Wishlistrepo;
import poc.example.wishlist_module.entity.Product;
import poc.example.wishlist_module.entity.WishListResponse;
import poc.example.wishlist_module.entity.Wishlist;
import poc.example.wishlist_module.global_exception.ProductNotAvailableException;

@Service                                   
@Transactional                              
public class Wishlistservice {
                                          
	@Autowired
	private Wishlistrepo wishlistrepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private APIClient apiClient;

	public WishListResponse addProduct(Wishlist wishList, Principal principal) {
		if (principal != null) {
			wishList.setUserId(principal.getName());

		}
		List<Product> allProducts = apiClient.getAllProducts();
		Product product = allProducts.stream().filter(p -> p.getId() == wishList.getProductId()).findAny().orElse(null);
		if (product == null) {
			throw new ProductNotAvailableException("Product is not availabe in the list", HttpStatus.NOT_FOUND);
		}
		wishlistrepo.save(wishList);
		WishListResponse wishListResponse = new WishListResponse(wishList, product);
		return wishListResponse;
	}

	
	public WishListResponse getProductById(Long wishListId) {
		Wishlist findById = wishlistrepo.findById(wishListId).orElse(null);
		System.out.println("findById is " + findById);
		if (findById == null) {
			throw new ProductNotAvailableException("WishList id is not present", HttpStatus.NOT_FOUND);
		}
		ResponseEntity<Product> productEntity = restTemplate
				.getForEntity("http://localhost:8082/api/product/" + findById.getProductId(), Product.class);
		Product product = productEntity.getBody();
		WishListResponse wishListResponse = new WishListResponse(findById, product);
		return wishListResponse;
	}

	
	public List<Wishlist> getProductsByUserId(Principal principal) {
		// Fetch products for the authenticated user
		String userId = getUserIdFromPrincipal(principal);
		return wishlistrepo.findByUserId(userId);
	}

	public String getUserIdFromPrincipal(Principal principal) {
		if (principal instanceof UsernamePasswordAuthenticationToken) {
			return ((UsernamePasswordAuthenticationToken) principal).getName();
		} else if (principal instanceof JwtAuthenticationToken) {
			// Assuming the subject in the JWT contains the user ID
			return ((JwtAuthenticationToken) principal).getTokenAttributes().get("sub").toString();
		}
		throw new IllegalArgumentException("Unsupported principal type: " + principal.getClass());
	}
	
	public void deleteFromWishlist(Long productId) {
		wishlistrepo.deleteByProductId(productId);
	}

}
