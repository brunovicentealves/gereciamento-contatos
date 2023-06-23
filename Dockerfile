FROM openjdk:11

ADD ./docker-spring-boot.jar gerenciamento-contatos.jar

ENTRYPOINT [“java”, “-jar”, “gerenciamento-contatos.jar”]