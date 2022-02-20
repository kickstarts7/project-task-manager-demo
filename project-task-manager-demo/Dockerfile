
FROM maven:3-openjdk-16 AS build

COPY src /usr/application/src/
COPY pom.xml /usr/application
USER root
RUN --mount=type=cache,target=/root/.m2 mvn -DskipTests=true -f /usr/application/pom.xml clean package

FROM openjdk:16-alpine3.13

COPY --from=build /usr/application/target/app.jar /usr/local/lib/app.jar

EXPOSE 8080:80

ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
