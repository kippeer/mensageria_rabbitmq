# Microserviços com RabbitMQ

Este projeto demonstra a implementação de uma arquitetura de microserviços utilizando Spring Boot e RabbitMQ para comunicação assíncrona entre serviços.

## 🚀 Arquitetura

O projeto consiste em dois microserviços:

- **Producer**: Responsável por receber requisições HTTP e publicar mensagens na fila do RabbitMQ
- **Consumer**: Consome mensagens da fila e processa-as

### Tecnologias Utilizadas

- Java 17
- Spring Boot 2.7.0
- Spring AMQP
- RabbitMQ
- Docker & Docker Compose

## 📋 Pré-requisitos

- Docker
- Docker Compose
- Java 17 (para desenvolvimento)
- Maven (para desenvolvimento)

## 🔧 Configuração e Execução

1. Clone o repositório:
```bash
git clone <repository-url>
cd microservices-rabbitmq
```

2. Execute os serviços com Docker Compose:
```bash
docker-compose up --build
```

3. Verifique se os serviços estão rodando:
- RabbitMQ Management: http://localhost:15672 (guest/guest)
- Producer API: http://localhost:8081
- Consumer (sem interface web)

## 📡 Endpoints

### Producer Service

- **Enviar Mensagem**
  ```
  POST http://localhost:8081/api/messages/{message}
  ```

- **Verificar Saúde do Serviço**
  ```
  GET http://localhost:8081/api/messages/health
  ```

## 🔍 Monitoramento

### Endpoints de Saúde

- Producer: http://localhost:8081/actuator/health
- Consumer: http://localhost:8080/actuator/health

### RabbitMQ Management

Acesse http://localhost:15672 com as credenciais:
- Username: guest
- Password: guest

## 🛠️ Desenvolvimento

### Estrutura do Projeto

```
microservices-rabbitmq/
├── producer/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── consumer/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── docker-compose.yml
└── README.md
```

### Compilação Local

Para compilar os serviços localmente:

```bash
# Compilar Producer
cd producer
mvn clean package

# Compilar Consumer
cd ../consumer
mvn clean package
```

## ⚙️ Configurações

### RabbitMQ

- **Queue**: mensagens
- **Exchange**: default (direct)
- **Routing Key**: mensagens

### Retry Policy

Ambos os serviços estão configurados com política de retry:
- Máximo de 3 tentativas
- Intervalo inicial de 1 segundo
- Multiplicador de 2.0
- Intervalo máximo de 10 segundos

## 🔐 Segurança

- Todas as credenciais estão configuradas via variáveis de ambiente
- Healthchecks implementados em todos os serviços
- Logs estruturados com SLF4J

## 📝 Logs

Os logs são gerados em formato estruturado e incluem:
- Timestamp
- Nível de log
- Serviço
- Mensagem
- Stack trace (em caso de erro)

## 🤝 Contribuindo

1. Fork o projeto
2. Crie sua Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## ✨ Melhorias Futuras

- Implementar autenticação/autorização
- Adicionar testes unitários e de integração
- Implementar circuit breaker
- Adicionar tracing distribuído
- Implementar métricas customizadas

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.