***********Spring Boot Integration with DAPR***********


  ***********Commands to Run Services:***********

  1. Order-Service:
  dapr run --app-id order-service --app-port 8081 -- java -jar target/ORDER-1.0-SNAPSHOT.jar

  2. Payment-Service:
  dapr run --app-id payment-service --app-port 8082 -- java -jar target/PAYMENT-1.0-SNAPSHOT.jar
