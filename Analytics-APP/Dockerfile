FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8200
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/analytics-app-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "/app/app.jar"]