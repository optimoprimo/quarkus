FROM maven:3.8.4-openjdk-17-slim AS builder

COPY . .

RUN  mvn -f pom.xml clean package

FROM registry.access.redhat.com/ubi8/openjdk-17:1.11

ENV LANG='en_US.UTF-8' \
    ENTORNO='DOCKER'

COPY --from=builder --chown=185 target/quarkus-app/lib/ /deployments/lib/
COPY --from=builder --chown=185 target/quarkus-app/*.jar /deployments/
COPY --from=builder --chown=185 target/quarkus-app/app/ /deployments/app/
COPY --from=builder --chown=185 target/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
USER 185
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"
