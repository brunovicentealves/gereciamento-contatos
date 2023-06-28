FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/gerenciamento-contatos.jar
WORKDIR /app
ENTRYPOINT java -jar gerenciamento-contatos.jar