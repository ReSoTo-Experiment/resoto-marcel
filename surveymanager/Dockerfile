FROM gradle:8.12.0-jdk23 AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src ./src
RUN gradle build --no-daemon -x test

FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar servermanager.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "servermanager.jar"]