FROM registry.access.redhat.com/ubi8/openjdk-17:1.11

ENV LANGUAGE='en_US:en'

COPY . $HOME/

RUN  mvn -f $HOME/pom.xml clean package

EXPOSE 8080
USER 185
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="$HOME/target/quarkus-app/quarkus-run.jar"

