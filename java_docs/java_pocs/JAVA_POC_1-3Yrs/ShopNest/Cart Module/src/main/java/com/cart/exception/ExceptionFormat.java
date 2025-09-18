package com.cart.exception;



public class ExceptionFormat {
	
	    private String errorStatusCode;
	    private String description;
	    
	    
	    
		public ExceptionFormat() {
			super();
			// TODO Auto-generated constructor stub
		}


		public ExceptionFormat(String errorStatusCode, String description) {
			super();
			this.errorStatusCode = errorStatusCode;
			this.description = description;
		}


		public String getErrorStatusCode() {
			return errorStatusCode;
		}


		public void setErrorStatusCode(String errorStatusCode) {
			this.errorStatusCode = errorStatusCode;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}
	
	    
}