package com.springcloud.rabbitmq;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/24 11:53
 */
@Configuration
public class RabbitMQConfig {
   /* *//**
     * 创建消息队列
     * @return
     *//*
    @Bean
    public Queue helloWorldQueue() {
        return new Queue("test");
    }

    *//**
     * 创建交换机
     * @return
     *//*
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct");
    }

    @Bean
    public TopicExchange topicExchange(){
        return  new TopicExchange("topic");
    }

    @Bean
    public Queue directQueue(){
        return new Queue("directQueue");
    }

    @Bean
    public Queue directQueue2(){
        return new Queue("directQueue2");
    }


    @Bean
    public Queue topicQueue(){
        return new Queue("topic.china");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topic2.china");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(this.directQueue()).to(this.directExchange()).with("error");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(this.directQueue2()).to(this.directExchange()).with("info");
    }


    @Bean
    public Binding binding3(){
        return BindingBuilder.bind(this.topicQueue()).to(this.topicExchange()).with("#.M");
    }

    @Bean
    public Binding binding4(){
        return BindingBuilder.bind(this.topicQueue()).to(this.topicExchange()).with("#.china");
    }*/


    @Bean
    public MessageConverter json(){
        return new Jackson2JsonMessageConverter();
    }
}
