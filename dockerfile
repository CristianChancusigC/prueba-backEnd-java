FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/prueba-java-0.0.1-SNAPSHOT.jar java-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]