
# syntax=docker/dockerfile:1

FROM openjdk:11
ARG JAR_FILE=validator-main/target/*.jar
COPY ${JAR_FILE} validator-main-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/validator-main-0.0.1-SNAPSHOT.jar"]