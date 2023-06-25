# RabbitMQ producer implementation using Springboot  
 Docker command used to run RabbitMQ locally:

 ``sudo docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management``

 To publish a message, use "/publish" endpoint using any REST client.
