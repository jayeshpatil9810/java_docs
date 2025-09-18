package com.cart.service;

import java.util.List;

import com.cart.dto.AddToCartDto;
import com.cart.dto.AppStatusDto;
import com.cart.dto.CartCostDto;
import com.cart.dto.CartPaymentRequest;
import com.cart.dto.DeleteCartDto;
import com.cart.model.Cart;

public interface CartService {
	
	AppStatusDto addItemToCart( AddToCartDto addToCartDto );

	DeleteCartDto deleteItemsByCartId(Integer cartItemId);
	
	public AppStatusDto updateItemInCart( Integer cartItemId, AddToCartDto addToCartDto);
	
	public List<Cart> getUserCartItems(String userId);
    
	public CartCostDto getCartTotalCost(Integer cartItemId);

	public CartCostDto getCartTotalCost(String userId);
	 
	public Object cartPayment(CartPaymentRequest paymentrequest);

	
	
	
}
