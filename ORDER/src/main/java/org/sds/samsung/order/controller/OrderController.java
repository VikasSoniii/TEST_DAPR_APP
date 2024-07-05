package org.sds.samsung.order.controller;

import org.sds.samsung.order.dto.OrderDTO;
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

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        logger.info("Received order: {}", orderDTO.toString());
        String response = orderService.createOrder(orderDTO);
        logger.info("Order processed with response: {}", response);
        return ResponseEntity.ok(response);
    }
}
