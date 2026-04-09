package com.example.forum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        log.debug("Received a request for a greeting by: {}", name);

        return String.format("Hello there, %s!", name);
    }
}
