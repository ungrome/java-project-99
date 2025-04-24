
FROM eclipse-temurin:20-jdk

ARG GRADLE_VERSION=8.7
RUN apt-get update && apt-get install -yq make unzip

COPY ./ .

RUN gradle installDist
EXPOSE 8080
CMD java -jar ./build/libs/app-0.0.1-SNAPSHOT.jar