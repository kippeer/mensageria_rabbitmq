package com.example.producer.controller;

import com.example.producer.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessagePublisher messagePublisher;

    @PostMapping("/{message}")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {
        try {
            messagePublisher.sendMessage(message);
            return ResponseEntity.ok("Mensagem enviada com sucesso: " + message);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao enviar mensagem: " + e.getMessage());
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Producer service is running!");
    }
}