FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/PAYMENT-1.0-SNAPSHOT.jar /payment-service.jar
ENTRYPOINT ["java","-jar","/payment-service.jar"]