FROM gradle:8.8-jdk17 AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build --no-daemon -x test

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar serverhandler.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "serverhandler.jar"]