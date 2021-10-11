FROM gradle:6.8-jdk11 AS clean
FROM gradle:6.8-jdk11 AS build
COPY --chown=gradle:gradle . gradle/src
WORKDIR gradle/src
RUN gradle build --no-daemon

FROM openjdk:11
ARG JAR_FILE=build/libs/exchange-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

