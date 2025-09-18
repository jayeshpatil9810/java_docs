package poc.example.wishlist_module.global_exception;

import org.springframework.http.HttpStatus;

public class ProductNotAvailableException extends RuntimeException {
	
	private HttpStatus httpCode;
	
	public ProductNotAvailableException(String message,HttpStatus httpCode) {
		super(message);
		this.httpCode=httpCode;
	}
	
	public HttpStatus gethttpCode() {
        return httpCode;
//
}
}