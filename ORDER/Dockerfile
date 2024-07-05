FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/ORDER-1.0-SNAPSHOT.jar /order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]
