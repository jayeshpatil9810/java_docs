package poc.example.wishlist_module.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "wishlist")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wishlist_id;
	private String userId;
	private Long productId;
	
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
     public Long getWishlist_id() {
	 return wishlist_id;
	
     }

	public void setWishlist_id(Long wishlist_id) {
		this.wishlist_id = wishlist_id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}


//	}
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Wishlist(Long wishlist_id, String userId, Long productId, LocalDateTime createdDate) {
	super();
	this.wishlist_id = wishlist_id;
	this.userId = userId;
	this.productId = productId;
	this.createdDate = createdDate;
   }
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Wishlist [wishlist_id=" + wishlist_id + ", userId=" + userId + ", productId=" + productId + ", createdDate="
				+ createdDate + "]";
	}
	
	
}