package com.cust_trial.journal.schedulecalendar;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories
@SpringBootApplication
@RestController
public class SchedulecalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulecalendarApplication.class, args);
    }





    @GetMapping("/ping")
    public String sayHello(@RequestParam(value = "value", defaultValue = "ok") String name) {

        return String.format("SC return %s!", name);
    }


}
