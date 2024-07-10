package org.sds.samsung.order.producer;

import org.springframework.stereotype.Service;

@Service
public class KafkaProducer{}
/*
{
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    DaprClient daprClient;

    @Autowired
    ObjectMapper objectMapper;

    public void sendMessage(OrderDTO orderDTO){
        logger.info("Publishing message: {}", orderDTO.toString());

        // Publishing messages
        */
/*daprClient.publishEvent(
                Constants.PUBSUB_NAME,
                Constants.DEFAULT_TOPIC_NAME,
                orderDTO,
                Collections.singletonMap(Metadata.TTL_IN_SECONDS, Constants.MESSAGE_TTL_IN_SECONDS)).block();*//*

        try {
            String message = objectMapper.writeValueAsString(orderDTO);
            daprClient.publishEvent(
                    Constants.PUBSUB_NAME,
                    Constants.DEFAULT_TOPIC_NAME,
                    message).block();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Published message done: {}", orderDTO.toString());
    }

    public void sendMessage(String topic, OrderDTO orderDTO) {
        try {
            String message = objectMapper.writeValueAsString(orderDTO);
            daprClient.publishEvent(PUBSUB_NAME, topic, message).block();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
