package com.springcloud.rabbitc;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitCApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitCApplication.class, args);
    }

    @Bean
    public MessageConverter json(){
        return new Jackson2JsonMessageConverter();
    }
}
