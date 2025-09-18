package poc.example.wishlist_module.global_exception;

public class ErrorMessage {
	private String Description;
	 private final int ErrorStatusCode;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getErrorStatusCode() {
		return ErrorStatusCode;
	}
	public ErrorMessage(String description, int errorStatusCode) {
		super();
		Description = description;
		ErrorStatusCode = errorStatusCode;
	}
	  
}
		
		
		
	



