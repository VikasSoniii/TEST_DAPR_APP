package org.sds.samsung.order.service;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import io.dapr.client.domain.Metadata;
import org.sds.samsung.order.constants.Constants;
import org.sds.samsung.order.dto.OrderDTO;
import org.sds.samsung.order.entity.Order;
import org.sds.samsung.order.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    DaprClient daprClient;

    @Autowired
    OrderRepository orderRepository;

    public String createOrder(OrderDTO orderDTO) {
        String result = Constants.EMPTY_STR;

        logger.info("Creating order: {}", orderDTO.toString());
        try {
            byte[] response = daprClient.invokeMethod(
                    Constants.PAYMENT_SERVICE,
                    Constants.SERVICE_METHOD,
                    orderDTO,
                    HttpExtension.POST,
                    byte[].class
            ).block();

            if (response != null) {
                result = new String(response);
            }

            logger.info("Received response from payment-service: {}", result);
            return result;
        } catch (Exception e) {
            logger.error("Error while invoking payment-service", e);
            return "Error processing order";
        }
    }


    //Publish Message to Kafka via DAPR CLIENT
    public void sendMessage(Order order){
        logger.info("starts: Publishing message: {}", order.toString());

        try {
            // Publishing messages
            daprClient.publishEvent(
                    Constants.PUBSUB_NAME,
                    Constants.DEFAULT_TOPIC_NAME,
                    order,
                    Collections.singletonMap(Metadata.TTL_IN_SECONDS, Constants.MESSAGE_TTL_IN_SECONDS)).block();

            logger.info("ends: Published message done: {}", order.toString());
        } catch (Exception e) {
            logger.info("ends: Exception while publishing message: {}", e.getMessage());
        }
    }

    public Order SaveOrderDetailDB(OrderDTO orderDTO){
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setAmount(orderDTO.getAmount());

        return orderRepository.save(order);
    }
}