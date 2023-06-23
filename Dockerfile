FROM openjdk:11

ADD ./gerenciamento-contatos.jar gerenciamento-contatos.jar

ENTRYPOINT [“java”, “-jar”, “gerenciamento-contatos.jar”]