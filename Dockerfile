FROM eclipse-temurin:21-jdk-alpine

# Install MySQL (not ideal on Alpine + JVM base)
RUN apk add --no-cache mysql mysql-client

# Set up working dir
WORKDIR /app

# Copy and build Spring Boot app
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Expose both ports
EXPOSE 8080 3306

# Start MySQL in background, then start Spring Boot
CMD sh -c "mysqld_safe & java -jar target/ems-backend-0.0.1-SNAPSHOT.jar"
