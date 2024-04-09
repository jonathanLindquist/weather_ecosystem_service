FROM amazoncorretto:21.0.2-alpine

# Configure working directory
RUN mkdir /app

COPY build/libs/*.jar /app/app.jar
WORKDIR /app

RUN apk add --no-cache curl

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]