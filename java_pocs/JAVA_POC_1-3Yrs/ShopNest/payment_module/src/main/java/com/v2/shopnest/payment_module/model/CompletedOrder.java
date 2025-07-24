package com.v2.shopnest.payment_module.model;

import java.awt.*;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CompletedOrder {
    private String status;
	@Id
    private String payId;
	private String coupon = "";
	@CreationTimestamp
	private LocalDateTime completedOrderDateTime;
	private String userId;

    public CompletedOrder(String status) {
        this.status = status;
    }

	public CompletedOrder() {
		super();
	}

	public CompletedOrder(String status, String payId, String coupon,String userId) {
		super();
		this.status = status;
		this.payId = payId;
		this.coupon = coupon;
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
    
    
}
