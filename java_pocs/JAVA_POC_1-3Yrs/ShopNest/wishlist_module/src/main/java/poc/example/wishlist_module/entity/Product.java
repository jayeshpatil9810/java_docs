package poc.example.wishlist_module.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String description;
	    private Long price;
	    private String category;
	    
	    public Product() {
	    	
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
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
		public Product(Long id, String name, String description, Long price) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", category=" + category + "]";
		}
		
		
		
	
}