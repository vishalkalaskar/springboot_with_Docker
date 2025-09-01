# Use Java 17 base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy built jar from target folder into container
COPY target/*.jar app.jar

# Expose port (same as Spring Boot server.port)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
