package com.ru.microservice.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Received_Messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "received_message")
    String message;

    @Column(name = "date")
    LocalDate date = LocalDate.now();

    @Column(name = "time")
    @DateTimeFormat(pattern = "HH:mm:ss")
    LocalTime time = LocalTime.now();
}