FROM maven
EXPOSE 9090
RUN mkdir mycode1
ADD . mycode1
WORKDIR  mycode1
RUN mvn clean install
ENTRYPOINT ["java","-jar","target/db-service-0.0.1-SNAPSHOT.jar"]