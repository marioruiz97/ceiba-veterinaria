FROM openjdk
ADD build/libs/*.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]