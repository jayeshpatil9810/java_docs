package poc.example.wishlist_module.entity;

public class WishListResponse {
	private Wishlist wishList;
	private Product product;
	public Wishlist getWishList() {
		return wishList;
	}
	public void setWishList(Wishlist wishList) {
		this.wishList = wishList;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public WishListResponse(Wishlist wishList, Product product) {
		super();
		this.wishList = wishList;
		this.product = product;
	}
	
	
	
	
}
