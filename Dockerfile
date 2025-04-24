FROM eclipse-temurin:21-jdk

ARG GRADLE_VERSION=8.7

WORKDIR /app

COPY /app .

RUN gradle installDist

EXPOSE 8080

CMD ./build/install/app/bin/app
