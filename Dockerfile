FROM adoptopenjdk:11-jdk-hotspot

WORKDIR /app

COPY target/gerenciamento-contatos.jar /app/gerenciamento-contatos.jar

EXPOSE 8080

CMD ["java", "-jar", "gerenciamento-contatos.jar"]