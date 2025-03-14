package com.example.producer.service;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.producer.config.RabbitMQConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessagePublisher {

    private static final Logger logger = LoggerFactory.getLogger(MessagePublisher.class);
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        try {
            rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, message);
            logger.info("Mensagem enviada com sucesso: {}", message);
        } catch (AmqpException e) {
            logger.error("Erro ao enviar mensagem: {}", e.getMessage());
            throw e;
        }
    }
}