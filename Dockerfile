FROM openjdk:8-jdk-alpine AS build
WORKDIR /src
COPY . .
RUN ./gradlew build

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build /src/application/configuration/build/libs/configuration.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]