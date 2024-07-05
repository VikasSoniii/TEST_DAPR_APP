package org.sds.samsung.order;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class);
    }
    @Bean
    public DaprClient getDaprClient() {
        return new DaprClientBuilder().build();
    }
}