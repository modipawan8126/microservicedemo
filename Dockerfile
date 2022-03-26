From openjdk:11

copy target/microservicedemo-0.0.1-SNAPSHOT.jar microservicedemo.jar

EXPOSE 9080

ARG DB_URL
ARG DB_USER
ARG DB_PASSWORD

ENV DB_URL $DB_URL
ENV DB_USER $DB_USER
ENV DB_PASSWORD $DB_PASSWORD

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "microservicedemo.jar"]