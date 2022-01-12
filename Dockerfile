
# syntax=docker/dockerfile:1

#WORKINGGGG -----------------------------
FROM openjdk:11
ARG JAR_FILE=validator-main/target/*.jar
COPY ${JAR_FILE} validator-main-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/validator-main-0.0.1-SNAPSHOT.jar"]

#FROM openjdk:16
#COPY ./validator-main/src/main/java/tml/centralapi/validatormain/ /
#WORKDIR /
#ENTRYPOINT ["java","ValidatorMainApplication.java"]