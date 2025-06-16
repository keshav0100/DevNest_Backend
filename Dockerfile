
FROM maven:3.8.6-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jre-slim
WORKDIR /app
COPY --from=build /app/target/projectify-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5454
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT:-5454}"]