
# syntax=docker/dockerfile:1

FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/validator-main-0.0.1-SNAPSHOT.jar"]