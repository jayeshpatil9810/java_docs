package poc.example.wishlist_module.entity;

public class WishListDetails {
	private String statusCode;
	private String description;
	private WishListResponse wishListResponse;
	
	
	public WishListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WishListDetails(String statusCode, String description, WishListResponse wishListResponse) {
	super();
	this.statusCode = statusCode;
	this.description = description;
	this.wishListResponse = wishListResponse;
}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public WishListResponse getWishListResponse() {
		return wishListResponse;
	}

	public void setWishListResponse(WishListResponse wishListResponse) {
		this.wishListResponse = wishListResponse;
	}
	
	
	
}
