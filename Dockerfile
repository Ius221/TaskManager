# Stage 1: Build the application using Maven
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lightweight image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
# Copy the built .jar file from the 'build' stage
COPY --from=build /app/target/EmployeeProject-0.0.1-SNAPSHOT.jar app.jar
# Expose the port the app runs on
EXPOSE 8080
# This is the command that will run when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]