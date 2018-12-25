FROM maven
EXPOSE 9091
ENV defaultZone $defaultZone
RUN mkdir mycode2
ADD . mycode2
WORKDIR  mycode2
RUN mvn clean install
ENTRYPOINT ["java","-jar","target/stock-service-0.0.1-SNAPSHOT.jar"]