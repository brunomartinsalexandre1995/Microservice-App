FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8100
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/Cinema-APP-1.0.0.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker", "-jar", "/app/app.jar"]