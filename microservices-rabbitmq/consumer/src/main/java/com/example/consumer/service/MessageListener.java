package com.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queuesToDeclare = @org.springframework.amqp.rabbit.annotation.Queue(name = "mensagens"))
    public void receiveMessage(String message) {
        try {
            logger.info("Mensagem recebida: {}", message);
            // Aqui você pode adicionar sua lógica de processamento da mensagem
            processMessage(message);
        } catch (Exception e) {
            logger.error("Erro ao processar mensagem: {}", e.getMessage());
        }
    }

    private void processMessage(String message) {
        // Implementar lógica de processamento da mensagem
        logger.info("Processando mensagem: {}", message);
    }
}