# Getting Started
git init
git remote add origin https://github.com/dch-microdemo/organization-service.git
git add .
git commit -m "Primera Subida"
git push -u origin master

# Branching:
git checkout -b micros_basicos
git push origin micros_basicos
git branch -a
git checkout master
git branch -a

# Kafka:

Levantar Server:

PS C:\tools\kafka_2.11-2.1.0> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties 
PS C:\tools\kafka_2.11-2.1.0> .\bin\windows\kafka-server-start.bat .\config\server.properties 

Enviar POST para guardar una Organizacion

Ver el topico creado y el objecto recibido:

.\kafka-topics.bat --list --zookeeper localhost:2181

.\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topi
c orgChangeTopic --from-beginning

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

