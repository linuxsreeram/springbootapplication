FROM maven
EXPOSE 8761
RUN mkdir mycode
ADD . mycode
WORKDIR  mycode
RUN mvn clean install -DskipTests
ENTRYPOINT ["java","-jar","target/eureka-service-0.0.1-SNAPSHOT.jar"]