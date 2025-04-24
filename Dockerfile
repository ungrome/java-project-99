FROM gradle:8.7-jdk21

WORKDIR /app

COPY . .

RUN gradle installDist
EXPOSE 8080
CMD build/libs/app-0.0.1-SNAPSHOT.jar app.jar