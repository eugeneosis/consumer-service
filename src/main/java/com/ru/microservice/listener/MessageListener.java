package com.ru.microservice.listener;

import com.ru.microservice.configuration.MQConfig;
import com.ru.microservice.model.Message;
import com.ru.microservice.service.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageListener {

    private final MessageServiceImpl messageServiceImpl;

    private static final String MESSAGE_EXCEPTION = "Message must not be empty";

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Message message) {
        validateMessage(message);
        messageServiceImpl.save(message);
        log.info("Received new message: {}", message.getMessage());
    }

    private void validateMessage(Message message) {
        if (message.getMessage().isEmpty() || message.getMessage() == null) {
            throw new RuntimeException(MESSAGE_EXCEPTION);
        }
    }
}