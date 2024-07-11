package org.sds.samsung.payment.service;

import org.sds.samsung.payment.dto.OrderEvent;
import org.sds.samsung.payment.entity.Payment;
import org.sds.samsung.payment.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    PaymentRepository paymentRepository;

    public String processPayment(String orderId) {
        return "Payment processed for Payment Id: " + orderId;
    }

    public String processPaymentDetails(OrderEvent orderEvent) {
        logger.info("Received processPaymentDetails request: {}", orderEvent);
        Payment payment = new Payment();

        if(orderEvent != null && orderEvent.getData() != null){
            payment.setOrderId(orderEvent.getData().getId());
            payment.setAmount(orderEvent.getData().getAmount());
            logger.info("Save processPaymentDetails : {}", payment);
            paymentRepository.save(payment);
            logger.info("Save processPaymentDetails : {}", payment);
            return "Payment details saved for Order Id: " + orderEvent.getData().getId();
        }else{
            return "PaymentService.processPaymentDetails()-> Order Event is null or empty";
        }
    }
}