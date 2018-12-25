FROM maven
EXPOSE 9092
ENV defaultZone $defaultZone
RUN mkdir mycode3
ADD . mycode3
WORKDIR  mycode3
RUN mvn clean install
ENTRYPOINT ["java","-jar","target/api-gateway-0.0.1-SNAPSHOT.jar"]