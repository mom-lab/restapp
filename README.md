#Descrição

Exemplo de aplicação Spring Boot com Rest API + Redis. Documentação da API disponivel em: [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui).
#Configuração do Redis
```bash
docker pull redis/redis-stack-server:latest
docker run -d --name redis-stack -p 6379:6379 -p 8001:8001 redis/redis-stack:latest
```

Consultar o Redis em :
http://localhost:8001/redis-stack/browser

#Executando
Abra o projeto no Spring Tool Suite como maven project e execute como "Spring Boot App"


#Testando
- apos executar o programa invocar a operação Get{id} observando que o cache está em uso via log da aplicação - Não exibindo a mensagem "Procurando por equipamento [xx]";

#Extra - adaptando para conectar no Azure Redis
spring.data.redis.host=<your-redis-name>.redis.cache.windows.net

spring.data.redis.port=6380

spring.data.redis.username=<your-redis-username>

spring.data.redis.ssl.enabled=true

spring.data.redis.azure.passwordless-enabled=true
