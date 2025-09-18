package com.cart.model;

import java.io.Serializable;

//public class PaymentOrder {
	public class PaymentOrder implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private String status;
		private String payId;
		private Long userId;
		private String redirectUrl;


		public PaymentOrder() {
			super();
		}

		public PaymentOrder(String status, String payId, Long userId, String redirectUrl) {
			super();
			this.status = status;
			this.payId = payId;
			this.userId = userId;
			this.redirectUrl = redirectUrl;
		}

		public PaymentOrder(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getPayId() {
			return payId;
		}

		public void setPayId(String payId) {
			this.payId = payId;
		}
		

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getRedirectUrl() {
			return redirectUrl;
		}

		public void setRedirectUrl(String redirectUrl) {
			this.redirectUrl = redirectUrl;
		}

	}


