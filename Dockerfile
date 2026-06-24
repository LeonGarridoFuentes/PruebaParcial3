FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY Inmobiliaria/demo/pom.xml .
RUN mvn dependency:go-offline -B

COPY Inmobiliaria/demo/src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

COPY --from=build /app/target/*.jar inmobiliaria-service.jar

ENV PORT=8081
EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "inmobiliaria-service.jar"]