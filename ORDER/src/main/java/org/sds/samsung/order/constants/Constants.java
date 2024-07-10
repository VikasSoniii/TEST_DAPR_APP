package org.sds.samsung.order.constants;

public class Constants {
    public static final String EMPTY_STR = "";
    public static final String PAYMENT_SERVICE = "payment-service";
    public static final String SERVICE_METHOD = "payment";

    //Kafka properties
    //Time-to-live for messages published.
    public static final String MESSAGE_TTL_IN_SECONDS = "10000";

    //The title of the topic to be used for publishing
    public static final String DEFAULT_TOPIC_NAME = "orders_topic";

    //The name of the pubsub
    public static final String PUBSUB_NAME = "kafka-pubsub";
}
