FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/venta_service-0.0.1.jar

COPY ${JAR_FILE} app_venta.jar
ENTRYPOINT ["java", "-jar", "app_venta.jar"]