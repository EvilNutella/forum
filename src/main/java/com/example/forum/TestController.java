package com.example.forum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // <- Говорит Спрингу, что этот класс является бином, чтобы Спринг сам создал объект
// + что этот бин должен принимать hhtp-запросы.
public class TestController {

    @PostMapping("/hello")
    public HelloResponseDto sayHelloPost(@RequestBody HelloRequestDto helloRequestDto) {
        // Формируем строку приветствия на основе данных из REQUEST DTO
        String message = "Hello there, " + helloRequestDto.getName();

        // Создаем и возвращаем индивидуальный объект RESPONSE DTO для этого запроса
        return new HelloResponseDto(message);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        log.debug("Received a request for a greeting by: {}", name);

        return String.format("Hello there, %s!", name);
    }
}

// @RequestParam - берем имя из строки URL;
// @RequestBody - берем имя из тела запроса;