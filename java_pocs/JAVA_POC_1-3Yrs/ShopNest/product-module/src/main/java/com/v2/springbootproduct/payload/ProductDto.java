package com.v2.springbootproduct.payload;

public class ProductDto {
	
	
	private Long id;
	private String name;
	private String description;
	private Long price;
	private String category;
	
	public ProductDto() {
	}
	
	public ProductDto(Long id, String name, String description, Long price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
