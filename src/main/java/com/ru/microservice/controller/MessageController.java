package com.ru.microservice.controller;

import com.ru.microservice.model.Message;
import com.ru.microservice.service.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class MessageController {

    private final MessageServiceImpl messageServiceImpl;

    private static final String FETCH_MESSAGES = "/messages";

    @GetMapping(FETCH_MESSAGES)
    public ResponseEntity<List<Message>> getAll() {
        log.info("Fetch all messages");
        return ResponseEntity.ok().body(messageServiceImpl.getAll());
    }
}