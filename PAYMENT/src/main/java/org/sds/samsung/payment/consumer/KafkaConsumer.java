package org.sds.samsung.payment.consumer;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    ObjectMapper objectMapper;

    /*//Subscribe to a topic
    @PostMapping(path = "/consumerOrdersTopic")
    public Mono<Void> handleMessage(@RequestBody(required = false) OrderEvent<OrderDTO> cloudEvent) {
        logger.info("Received OrderEvent: {}", cloudEvent);

        return Mono.fromRunnable(() -> {
            try {
                if (cloudEvent != null && cloudEvent.getData() != null) {
                    OrderDTO orderDTO = cloudEvent.getData();
                    logger.info("Received order details: {}", orderDTO);

                    // Process the received orderDTO here
                    //processOrder(orderDTO);
                } else {
                    logger.warn("Received empty or null OrderEvent");
                }
            } catch (Exception e) {
                logger.error("Exception while processing message: {}", e.getMessage(), e);
                throw new RuntimeException(e);
            }
        });
    }*/
}
