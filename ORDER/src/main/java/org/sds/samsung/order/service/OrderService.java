package org.sds.samsung.order.service;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import org.sds.samsung.order.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    public static final String EMPTY_STR = "";
    public static final String PAYMENT_SERVICE = "payment-service";
    public static final String SERVICE_METHOD = "payment";
    @Autowired
    DaprClient daprClient;

    public String createOrder(OrderDTO orderDTO) {
        String result = EMPTY_STR;

        logger.info("Creating order: {}", orderDTO.toString());
        try {
            byte[] response = daprClient.invokeMethod(
                    PAYMENT_SERVICE,
                    SERVICE_METHOD,
                    orderDTO,
                    HttpExtension.POST,
                    byte[].class
                    ).block();

            if(response != null) {
                result = new String(response);
            }

            logger.info("Received response from payment-service: {}", result);
            return result;
        } catch (Exception e) {
            logger.error("Error while invoking payment-service", e);
            return "Error processing order";
        }


    }
}
