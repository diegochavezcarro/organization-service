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

Del lado del ms de licencias comprobar que en los logs aparece el mensaje recibido

### Reference Documentation
For further reference, please consider the following sections:

https://dzone.com/articles/magic-of-kafka-with-spring-boot

https://memorynotfound.com/spring-kafka-json-serializer-deserializer-example/

https://github.com/carnellj/spmia-chapter8/

https://codenotfound.com/spring-kafka-json-serializer-deserializer-example.html

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)


