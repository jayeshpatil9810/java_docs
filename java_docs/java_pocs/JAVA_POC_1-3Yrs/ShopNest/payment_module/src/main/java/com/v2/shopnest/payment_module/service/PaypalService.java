package com.v2.shopnest.payment_module.service;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCaptureRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.PurchaseUnitRequest;
import com.v2.shopnest.payment_module.config.CouponServiceClient;
import com.v2.shopnest.payment_module.exception.PaypalCaptureException;
import com.v2.shopnest.payment_module.model.CompletedOrder;
import com.v2.shopnest.payment_module.model.PaymentOrder;
import com.v2.shopnest.payment_module.model.PaypalWebhookEvent;
import com.v2.shopnest.payment_module.repository.PaymentRepository;

/**
 * Service class for interacting with PayPal API for payment processing.
 */
@Service
public class PaypalService {

	private final String url;
	private final PayPalHttpClient payPalHttpClient;
	private final PaymentRepository paymentRepository;
	private final CouponServiceClient couponServiceClient;

	
	public PaypalService(@Value("${url}") String url, PayPalHttpClient payPalHttpClient,
			PaymentRepository paymentRepository, CouponServiceClient couponServiceClient) {
		this.url = url;
		this.payPalHttpClient = payPalHttpClient;
		this.paymentRepository = paymentRepository;
		this.couponServiceClient = couponServiceClient;
	}


	private static final Logger logger = Logger.getLogger(PaypalService.class.getName());



	public Object createOrder(Double amount, String coupon, String userId) {
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.checkoutPaymentIntent("CAPTURE");
		AmountWithBreakdown amountBreakdown = new AmountWithBreakdown().currencyCode("USD").value(amount.toString());
		PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest().amountWithBreakdown(amountBreakdown);
		List<PurchaseUnitRequest> purchaseUnitRequests = Arrays.asList(purchaseUnitRequest);
		orderRequest.purchaseUnits(purchaseUnitRequests);

		/*
		 * if (coupon != null) { ApplicationContext applicationContext = new
		 * ApplicationContext() .returnUrl(url + "/capture/" + userId + "/" + coupon)
		 * .cancelUrl(url + "/cancel");
		 * orderRequest.applicationContext(applicationContext);
		 * 
		 * } else { ApplicationContext applicationContext = new ApplicationContext()
		 * .returnUrl(url + "/capture/" + userId) .cancelUrl(url + "/cancel");
		 * orderRequest.applicationContext(applicationContext);
		 * 
		 * }
		 */
		
		
		 orderRequest.applicationContext((!Objects.equals(coupon, ""))
		            ? new ApplicationContext()
		                    .returnUrl(url + "/capture/" + userId + "/" + coupon)
		                    .cancelUrl(url + "/cancel")
		            : new ApplicationContext()
		                    .returnUrl(url + "/capture/" + userId)
		                    .cancelUrl(url + "/cancel"));
		
		
		OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest().requestBody(orderRequest);


		try {
			HttpResponse<Order> orderHttpResponse = payPalHttpClient.execute(ordersCreateRequest);
			Order order = orderHttpResponse.result();

			String redirectUrl = order.links().stream().filter(link -> "approve".equals(link.rel())).findFirst()
					.orElseThrow(NoSuchElementException::new).href();

			//return new PaymentOrder("success", order.id(), userId, redirectUrl);
			LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
			map.put("appStatusCode", "2000");
			map.put("description", "Order Created Successfully");
			map.put("orderDetails", new PaymentOrder("success", order.id(), userId, redirectUrl));
			return map;

		} catch (IOException e) {

			return new PaymentOrder("Error");
		}
	}

	public Object completePayment(String token, String coupon, String userId) {
		OrdersCaptureRequest ordersCaptureRequest = new OrdersCaptureRequest(token);
		LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
		map.put("appStatusCode", "2000");
		map.put("description", "Payment Successful");
		try {
			HttpResponse<Order> httpResponse = payPalHttpClient.execute(ordersCaptureRequest);
			if (httpResponse.result().status() != null) {
				CompletedOrder completedOrder = new CompletedOrder("success", token, coupon, userId);
				if (coupon != null) {
					couponServiceClient.updateCouponByCode(coupon, true);
					//return paymentRepository.save(completedOrder);
				}
				map.put("paymentDetails",paymentRepository.save(completedOrder));
				return map;
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error capturing PayPal order with token: " + token, e);
			throw new PaypalCaptureException("Error capturing PayPal order. Please try again later.", e);
		}

		CompletedOrder completedOrder = new CompletedOrder("error", token, coupon, userId);
		return completedOrder;
	}
	
	
	@Transactional
	public void onPaymentCreated(PaypalWebhookEvent event) {
		// Update database record or perform other actions based on payment creation
		System.out.println("Webhook called...");
	}

	@Transactional
	public void onPaymentCompleted(PaypalWebhookEvent event) {
		// Update database record or perform other actions based on payment completion
		// For example, send notification to user
		System.out.println("Webhook called...");
	}
	

}
