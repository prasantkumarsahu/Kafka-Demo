# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy only the Maven project descriptor to cache dependencies (optional optimization)
COPY pom.xml .
COPY src ./src

# Install dependencies and build the application
RUN mvn clean package -DskipTests

# Stage 2: Package the application in a lightweight container
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
