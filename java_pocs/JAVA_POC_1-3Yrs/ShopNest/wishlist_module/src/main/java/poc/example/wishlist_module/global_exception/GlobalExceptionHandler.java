package poc.example.wishlist_module.global_exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotAvailableException.class)
	public ResponseEntity<ErrorMessage> handleProductNotAvailableException(ProductNotAvailableException ex){
		Map<String, Object> responseMap = new LinkedHashMap<>();

        // Add description and appStatusCode
        responseMap.put("Description", ex.getMessage());
        responseMap.put("AppStatusCode", ex.gethttpCode().value());
		ErrorMessage errorMessage = new ErrorMessage(
				ex.getMessage(), 
				4001
				);
		return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
	}

}
