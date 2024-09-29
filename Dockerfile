FROM openjdk:17
WORKDIR /app
COPY target/*.jar application.jar
ENTRYPOINT ["javar", "-jar", "application.jar"]
