FROM openjdk:17-jdk-alpine

COPY target/Parcial2-0.0.1-SNAPSHOT.jar /app/Parcial2-0.0.1-SNAPSHOT.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/Parcial2-0.0.1-SNAPSHOT.jar"]