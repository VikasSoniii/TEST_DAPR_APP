package org.sds.samsung.payment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dapr.Topic;
import org.sds.samsung.payment.dto.OrderDTO;
import org.sds.samsung.payment.dto.OrderEvent;
import org.sds.samsung.payment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    PaymentService paymentService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/payment")
    public String processPayment(@RequestBody OrderDTO orderDTO) {
        logger.info("Received payment request: {}", orderDTO.toString());
        String response = paymentService.processPayment(orderDTO.getOrderId());
        logger.info("Payment processed with response: {}", response);
        return response;
    }

    //Subscribe to a topic
    @Topic(name = "orders_topic", pubsubName = "kafka-pubsub")
    @PostMapping(path = "/consumerOrdersTopic")
    public Mono<Void> handleMessage(@RequestBody(required = false) String orderEventStr)  {
        logger.info("Received OrderEvent: {}", orderEventStr);

        return Mono.fromRunnable(() -> {
            try {
                if (orderEventStr != null) {
                    // Parse JSON string to Java object
                    OrderEvent orderEvent = objectMapper.readValue(orderEventStr, OrderEvent.class);
                    logger.info("Subscriber received: Payment Id: " + orderEvent.getData().getOrderId() +
                            " and Amount: " + orderEvent.getData().getAmount());
                    // Process Payment Data
                    logger.info("------Call paymentService.processPaymentDetails()----- ");
                    paymentService.processPaymentDetails(orderEvent);
                } else {
                    logger.warn("Received empty or null OrderEvent");
                }
            } catch (Exception e) {
                logger.error("Exception while processing message: {}", e.getMessage(), e);
                throw new RuntimeException(e);
            }
        });
    }
}