FROM amazoncorretto:21.0.2-alpine

# Configure working directory
RUN mkdir /app

COPY build/libs/*.jar /app/app.jar
WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]