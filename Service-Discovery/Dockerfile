FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Bruno Alexandre
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean package
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/Service-Discovery-1.0.0.jar /app/
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "Service-Discovery-1.0.0.jar"]