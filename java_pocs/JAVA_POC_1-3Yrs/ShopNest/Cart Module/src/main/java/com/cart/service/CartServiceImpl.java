package com.cart.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import com.cart.exception.InvalidCouponException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cart.dto.AddToCartDto;
import com.cart.dto.AppStatusDto;
import com.cart.dto.CartCostDto;
import com.cart.dto.CartPaymentRequest;
import com.cart.dto.CartResponse;
import com.cart.dto.DeleteCartDto;
import com.cart.dto.OrderRequest;
import com.cart.exception.ProductNotAvailableException;
import com.cart.exception.UserNotLoggedInException;
import com.cart.model.Cart;
import com.cart.model.Product;
import com.cart.model.User;
import com.cart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired
	private ApiClient apiClient;
	@Autowired
	private UserClient userClient;
	boolean isLoggedIn = false;

	@Value("${url}")
	private String url;

	@Override
	public AppStatusDto addItemToCart(AddToCartDto addToCartDto) {

//		System.out.println("isLogged in " + isLoggedIn);
//
//		User loggedInUser = userClient.loginUser(addToCartDto.getUserId());
//		if (loggedInUser.isLoggedIn() == false) {
//			throw new UserNotLoggedInException("User is not logged in");
//		}

		// Product product = client.getProductById(addToCartDto.getProductId());

		ResponseEntity<Product> forEntity = restTemplate.getForEntity(url + addToCartDto.getProductId(), Product.class);
	
		Product product1 = forEntity.getBody();
		System.out.println(product1.getName());
		System.out.println(product1.getPrice());
		

		Cart cart = new Cart();
		cart.setQuantity(addToCartDto.getQuantity());
		cart.setUserId(addToCartDto.getUserId());
		Double totalCost = 0d;
		totalCost = addToCartDto.getQuantity() * product1.getPrice();
		System.out.println(totalCost);
		cart.setTotalCost(totalCost);
		cart.setProduct(product1);

		Cart save = cartRepository.save(cart);

		AppStatusDto appStatusDto = new AppStatusDto();
		appStatusDto.setDescription("product added sucessfully to the cart");
		appStatusDto.setAppStatusCode("2001");

		CartResponse dto = new CartResponse();
		BeanUtils.copyProperties(save, dto);
		appStatusDto.setCartResponse(dto);

		LinkedHashSet<Object> cartset = new LinkedHashSet<Object>();
		boolean CartStatus = cartset.add(appStatusDto);
		return appStatusDto;

	}

	@Override
	public DeleteCartDto deleteItemsByCartId(Integer cartItemId) {
		cartRepository.deleteById(cartItemId);

		DeleteCartDto deleteCartDto = new DeleteCartDto();
		deleteCartDto.setDescription("Cart item  deleted successfully");
		deleteCartDto.setAppStatusCode("2000");

		return deleteCartDto;
	}

	@Override
	public AppStatusDto updateItemInCart(Integer cartItemId, AddToCartDto addToCartDto) {
		Optional<Cart> findById = cartRepository.findById(cartItemId);
		Cart cartItem = findById.get();

		ResponseEntity<Product> forEntity = restTemplate.getForEntity(url + addToCartDto.getProductId(), Product.class);
		Product product = forEntity.getBody();
		if (product == null) {
			throw new ProductNotAvailableException("Product is not availabe ");
		}

		cartItem.setQuantity(addToCartDto.getQuantity());
		cartItem.setTotalCost(addToCartDto.getQuantity() * product.getPrice());

		Cart save = cartRepository.save(cartItem);
		AppStatusDto appStatusDto = new AppStatusDto();
		appStatusDto.setDescription("product added sucessfully to the cart");
		appStatusDto.setAppStatusCode("2001");

		CartResponse dto = new CartResponse();
		BeanUtils.copyProperties(save, dto);
		appStatusDto.setCartResponse(dto);

		LinkedHashSet<Object> cartset = new LinkedHashSet<Object>();
		boolean CartStatus = cartset.add(appStatusDto);
		return appStatusDto;

	}

	public CartCostDto getCartTotalCost(Integer cartItemId) {
		Optional<Cart> findById = cartRepository.findById(cartItemId);
		Cart cart = findById.get();
		CartCostDto cartCostDto = new CartCostDto();
		cartCostDto.setDescription("Cost calculated successfully");
		cartCostDto.setAppStatusCode("2001");
		cartCostDto.setTotalCost(cart.getTotalCost());

		return cartCostDto;

	}

	@Override
	public CartCostDto getCartTotalCost(String userId) {
		Double cost = 0d;
		List<Cart> userCartItems = cartRepository.findByUserId(userId);
		for (Cart c : userCartItems) {
			double totalCost = c.getTotalCost();
			cost = cost + totalCost;

		}
		CartCostDto cartCostDto = new CartCostDto();
		cartCostDto.setDescription(" User cart cost calculated successfully");
		cartCostDto.setAppStatusCode("2001");
		cartCostDto.setTotalCost(cost);
		return cartCostDto;

	}

	public Object cartPayment(CartPaymentRequest paymentrequest) {

		try {
			Double cost = 0d;
			List<Cart> userCartItems = cartRepository.findByUserId(paymentrequest.getUserId());
			for (Cart c : userCartItems) {
				double totalCost = c.getTotalCost();
				cost = cost + totalCost;
			}
			String userId = paymentrequest.getUserId();
			String couponCode = paymentrequest.getCouponCode();
			OrderRequest OrderRequest=new OrderRequest();
			OrderRequest.setAmount(cost);
			OrderRequest.setUserId(userId);
			OrderRequest.setCouponCode(couponCode);
			Object createOrder = apiClient.createOrder(OrderRequest);
			System.out.println(createOrder);
			return  createOrder;
		} catch (Exception e) {
			throw new InvalidCouponException("Invalid coupon or criteria not met", HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public List<Cart> getUserCartItems(String userId) {
		List<Cart> userCartItems = cartRepository.findByUserId(userId);
		return userCartItems;
	}

}
