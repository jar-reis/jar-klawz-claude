FROM eclipse-temurin:25-jdk-alpine AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Download dependencies and build
RUN ./mvnw clean package -DskipTests || \
    (apk add --no-cache maven && mvn clean package -DskipTests)

# Runtime stage
FROM eclipse-temurin:25-jre-alpine

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Run as non-root
RUN addgroup -S klawz && adduser -S klawz -G klawz
USER klawz

EXPOSE 8081

HEALTHCHECK --interval=10s --timeout=5s --start-period=30s --retries=3 \
    CMD wget -qO- http://localhost:8081/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
