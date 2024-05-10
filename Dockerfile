FROM openjdk:17
WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
CMD ["java", "-jar", "ManualTesting-PET-0.0.1-SNAPSHOT.jar"]
