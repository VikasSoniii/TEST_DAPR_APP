package org.sds.samsung.order.controller;

import org.sds.samsung.order.dto.OrderDTO;
import org.sds.samsung.order.entity.Order;
import org.sds.samsung.order.producer.KafkaProducer;
import org.sds.samsung.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService;

    @Autowired
    KafkaProducer kafkaProducer;

    //Method for call Payment Service using DAPR Client (Service-to-service invocation)
    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        logger.info("Received order: {}", orderDTO.toString());
        String response = orderService.createOrder(orderDTO);
        logger.info("Order processed with response: {}", response);
        return ResponseEntity.ok(response);
    }

    //Method for call publishing message into Kafka MQ
    @PostMapping("/publish")
    public ResponseEntity<String> publishEvent(@RequestBody OrderDTO orderDTO) {
        logger.info("Message Received for publishing: {}", orderDTO.toString());

        //Save order details into DB
        Order order = orderService.SaveOrderDetailDB(orderDTO);
        if(order != null && order.getId() != null){
            //publish message to the Kafka MQ
            orderService.sendMessage(order);
            logger.info("Order message published and sent via Dapr");
        }

        return ResponseEntity.ok("Order message published and sent via Dapr");
    }
}