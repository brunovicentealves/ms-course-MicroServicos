package com.bruno.hrpayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bruno.hrpayroll.entities.Payment;
import com.bruno.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@HystrixCommand(fallbackMethod = "getPaymentAlterantive")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workerId, days);

		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<Payment> getPaymentAlterantive(Long workerId, Integer days) {
		Payment payment = new Payment("Brann", 400.00, days);

		return ResponseEntity.ok(payment);
	}

}
