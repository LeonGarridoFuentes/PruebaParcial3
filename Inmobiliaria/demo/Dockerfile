FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar inmobiliaria-service.jar


ENV PORT=8080
ENV SPRING_PROFILES_ACTIVE=local

EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "inmobiliaria-service.jar"]