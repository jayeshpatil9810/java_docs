package com.cart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id;
	private String name;
	private double price;
	private String description;
	private String category;
	
	@JsonManagedReference 
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	private List<Cart> cart=new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
