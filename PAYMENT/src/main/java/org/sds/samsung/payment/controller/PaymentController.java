package org.sds.samsung.payment.controller;

import org.sds.samsung.payment.dto.OrderDTO;
import org.sds.samsung.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public String processPayment(@RequestBody OrderDTO orderDTO) {
        logger.info("Received payment request: {}", orderDTO.toString());
        String response = paymentService.processPayment(orderDTO.getOrderId());
        logger.info("Payment processed with response: {}", response);
        return response;
    }
}