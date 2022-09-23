# Build
# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:7.4-jdk11-alpine as builder

# Copy local code to the container image.
WORKDIR /app
ADD --chown=gradle:gradle ./ /app
RUN chmod +x gradlew
RUN ./gradlew build --stacktrace


#Build APP Container
FROM openjdk:11-jdk-slim

COPY --from=builder /app/boot/build/libs/sample-app.jar /app/sample-app.jar

RUN groupadd -r svc && useradd --no-log-init -r -g svc svc
USER svc

EXPOSE 8080
ENTRYPOINT java $JAVA_OPTS -jar /app/sample-app.jar