package org.sds.samsung.payment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public String processPayment(String orderId) {
        return "Payment processed for Order Id: " + orderId;
    }
}