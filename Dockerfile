# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the jar file (after build) into the container
COPY target/formula-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render uses $PORT env, we handle it in application.properties)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
