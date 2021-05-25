FROM openjdk:11-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} BackendApplication.jar
ENTRYPOINT ["java","-jar","/BackendApplication.jar"]