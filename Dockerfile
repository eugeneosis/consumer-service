FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/consumer-service-1.0.0.jar .
CMD ["java","-jar","consumer-service-1.0.0.jar"]

