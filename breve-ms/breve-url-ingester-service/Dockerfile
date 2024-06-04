# Stage 1: Build the application
FROM maven:latest AS build
WORKDIR /workspace
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final Docker image
FROM openjdk:22-jdk
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]      