package com.duoc.gestionpedidos.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.duoc.gestionpedidos.config.RabbitMQConfig;

@Service
public class MensajeService {

    private final RabbitTemplate rabbitTemplate;

    public MensajeService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensaje(String mensaje) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.MAIN_QUEUE, mensaje);
    }

    public void enviarObjeto(Object objeto) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.MAIN_QUEUE, objeto);
    }
}