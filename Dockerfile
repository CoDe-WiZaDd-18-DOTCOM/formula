# -------- Build Stage --------
FROM eclipse-temurin:21-alpine AS build
WORKDIR /app

# Copy wrapper files and pom.xml first (helps Docker cache them)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execution permission to mvnw
RUN chmod +x mvnw

# Copy the rest of the source code
COPY src ./src

# Build the project using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# -------- Run Stage --------
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/formula-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
