***********Spring Boot Integration with DAPR***********


  ***********Commands to Run Services:***********

  1. Order-Service:
  dapr run --app-id order-service --app-port 8081 --dapr-http-port 3500 -- java -jar target/ORDER-1.0-SNAPSHOT.jar

  2. Payment-Service:
  dapr run --app-id payment-service --app-port 8082 --dapr-http-port 3501 -- java -jar target/PAYMENT-1.0-SNAPSHOT.jar

***********How to Test Order & Payment Services***********
1. Order-Service:

   Communication via localhost:

   - SERVICE TO SERVICE INVOCATION - "Order-service" Internally call "Payment-Service"(Endpoint is /payment)
   
     POST http://localhost:8081/order                                    
 
    Communication via DAPR PORT:
    - SERVICE TO SERVICE INVOCATION - "Order-service" Internally call "Payment-Service"(Endpoint is /payment)
    
      POST http://localhost:3500/v1.0/invoke/order-service/method/order         

3. Payment-Service:

    - Communication via Localhost:
   
      POST http://localhost:8082/payment

    - Communication via DAPR:
   
      POST http://localhost:3501/v1.0/invoke/payment-service/method/payment





******************************************************************************************************************************************
********************DAPR Integration with Kafka********************


   ***********Commands to Run Services:***********

     1. Order-Service: dapr run --app-id order-service --app-port 8081 --dapr-http-port 3500 --resources-path ./components -- java -jar target/ORDER-1.0-SNAPSHOT.jar

     2. Payment-Service: dapr run --app-id payment-service --app-port 8082 --dapr-http-port 3501 --resources-path ./components -- java -jar target/PAYMENT-1.0-SNAPSHOT.jar

How to Test Order & Payment Services

- Order-Service:

      1. Message Publishing to Kafka MQ - Use Localhost

         POST http://localhost:8081/publish

      2. Message Publishing to Kafka MQ - Using DAPR

         POST http://localhost:3500/v1.0/invoke/order-service/method/publish

- Payment-Service:

     Check Subscriber Logs from Payment Service     
