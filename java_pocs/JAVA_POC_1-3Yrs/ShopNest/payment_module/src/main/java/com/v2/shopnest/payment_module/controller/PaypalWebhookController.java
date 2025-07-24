package com.v2.shopnest.payment_module.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v2.shopnest.payment_module.model.PaypalWebhookEvent;
import com.v2.shopnest.payment_module.service.PaypalService;

@RestController
@RequestMapping(value = "/api/paypal/webhook")
public class PaypalWebhookController {

	@Autowired
	private PaypalService paymentService;

	@PostMapping()
	public ResponseEntity<Void> handleWebhookNotification(@RequestBody PaypalWebhookEvent event,
			@RequestHeader("PAYPAL-AUTH-ALGO") String algorithm, @RequestHeader("PAYPAL-AUTH-SIG") String signature,
			HttpServletRequest request) {
			System.out.println("Webhook called...");
		// Verify the signature of the webhook notification
		if (!verifySignature(request, algorithm, signature, event)) {
			return ResponseEntity.badRequest().build();
		}

		// Process event based on its type
		switch (event.getEvent_type()) {
		case "PAYMENT.CAPTURE.CREATED":
			paymentService.onPaymentCreated(event);
			System.out.println("Webhook called...");
			break;
		case "PAYMENT.CAPTURE.COMPLETED":
			paymentService.onPaymentCompleted(event);
			System.out.println("Webhook called...");
			break;
		// ... handle other event types
		default:
			// log.warn("Unknown event type: {}", event.getEvent_type());
		}

		return ResponseEntity.ok().build();
	}

	private boolean verifySignature(HttpServletRequest request, String algorithm, String signature,
			PaypalWebhookEvent event) {
		String webhookSecret = "EHOq0Ap0nITjKnx0DLYNqcebdNujC1wjMlW90iL5HvTZaFarUFmsB6IIt1TaMBP2xkcnRtnxKmd8uEdd"; // Replace with your actual webhook secret

		// Construct the payload string (use the raw request body)
		String payload = getRequestBody(request);

		// Construct the signature string
		String expectedSignature = "sha256=" + HmacUtils.hmacSha256Hex(webhookSecret, payload);

		// Compare the calculated signature with the provided signature
		return expectedSignature.equals(signature);
	}

	private String getRequestBody(HttpServletRequest request) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = request.getReader()) {
			char[] charBuffer = new char[128];
			int bytesRead;
			while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
				stringBuilder.append(charBuffer, 0, bytesRead);
			}
		} catch (IOException e) {
			// Handle exception
		}
		return stringBuilder.toString();
	}
}
