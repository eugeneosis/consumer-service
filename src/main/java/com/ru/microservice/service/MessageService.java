package com.ru.microservice.service;

import com.ru.microservice.model.Message;

import java.util.List;

public interface MessageService {

    Message save(Message message);

    Message saveAsParam(Message message);

    List<Message> getAll();
}