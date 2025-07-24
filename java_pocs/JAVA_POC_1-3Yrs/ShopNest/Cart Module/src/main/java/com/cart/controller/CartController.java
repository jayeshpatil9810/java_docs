package com.cart.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dto.AddToCartDto;
import com.cart.dto.AppStatusDto;
import com.cart.dto.CartCostDto;
import com.cart.dto.CartPaymentRequest;
import com.cart.dto.DeleteCartDto;
import com.cart.model.Cart;
import com.cart.service.CartService;


@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    //adding product to cart
    @PostMapping()
    public AppStatusDto addItemToCart(@RequestBody AddToCartDto addToCartDto, Principal principal) {
        addToCartDto.setUserId(principal.getName());
        AppStatusDto addItemToCart = cartService.addItemToCart(addToCartDto);
        return addItemToCart;

    }

    //deleting product to cart
    @DeleteMapping("/{cartItemId}")
    public DeleteCartDto deleteItemsByCartId(@PathVariable Integer cartItemId) {
        return cartService.deleteItemsByCartId(cartItemId);

    }

    //updating product in cart
    @PutMapping("/{cartItemId}")
    public AppStatusDto updateItemInCart(@PathVariable Integer cartItemId, @RequestBody AddToCartDto addToCartDto, Principal principal) {
        addToCartDto.setUserId(principal.getName());
        AppStatusDto updateItemInCart = cartService.updateItemInCart(cartItemId, addToCartDto);
        return updateItemInCart;

    }

    //getting user cart
    @GetMapping("/getusercart")
    public List<Cart> getUserCartItems(Long userId, Principal principal) {
        List<Cart> userCartItems = cartService.getUserCartItems(principal.getName());
        return userCartItems;
    }

    //getting total cost for a particular cartItem
    @GetMapping("/getcartcost/{cartItemId}")
    public CartCostDto getCartTotalCost(@PathVariable Integer cartItemId) {
        return cartService.getCartTotalCost(cartItemId);

    }

    //getting total  cartcost for a user
    @GetMapping("/usercartcost")
    public CartCostDto getCartTotalCostByUserId(Principal principal) {
        return cartService.getCartTotalCost(principal.getName());


    }

    //cart payment by a user
    @PostMapping("/cartpaymentbyuser")
    public Object CartPaymentByUser(@RequestBody CartPaymentRequest paymentrequest, Principal principal) {
        paymentrequest.setUserId(principal.getName());
        Object cartPayment = cartService.cartPayment(paymentrequest);
        return cartPayment;
    }


}
