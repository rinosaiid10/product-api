

FROM eclipse-temurin:17-jdk-alpine
LABEL authors="rino"

WORKDIR /app

COPY target/product.jar ./product.jar

EXPOSE 8082

CMD ["java", "-jar", "product.jar"]