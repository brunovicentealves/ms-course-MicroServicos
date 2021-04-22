package com.bruno.hrpayroll.service;

import org.springframework.stereotype.Service;
import com.bruno.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {

		return new Payment("BOb", 200.0, days);

	}

}
