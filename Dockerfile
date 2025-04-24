
FROM eclipse-temurin:20-jdk

ARG GRADLE_VERSION=8.7
RUN apt-get update && apt-get install -yq make unzip

COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY build .

RUN ./gradlew --no-daemon dependencies

COPY lombok.config .
COPY src src

RUN ./gradlew --no-daemon build
EXPOSE 8080
CMD java -jar build/libs/app-0.0.1-SNAPSHOT.jar