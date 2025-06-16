FROM maven:3.8.6-openjdk-11-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /target/projectify-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 5454
ENTRYPOINT ["java", "-jar", "/app.jar"]
