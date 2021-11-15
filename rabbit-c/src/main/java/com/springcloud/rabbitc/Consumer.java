package com.springcloud.rabbitc;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/24 11:45
 */
@Component
public class Consumer {

    @RabbitListener(queues = "test")
    public void getMessage(String message){
        System.out.println(message+"------getMessage1"+ LocalDateTime.now());
        return;
    }


    @RabbitListener(queues = "test")
    public void getMessage2(String message) throws InterruptedException {
        System.out.println(message+"------getMessage2"+ LocalDateTime.now());
        Thread.sleep(200);
        return;
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "directQueue2"),
                    exchange =@Exchange(name = "direct"),
                    key = "info"
            )})
    public void getMessage3(String message) throws InterruptedException {
        System.out.println(message+"------getMessage3-------"+ LocalDateTime.now());
        return;
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "directQueue2"),
                    exchange =@Exchange(name = "direct"),
                    key = "error"
            )})
    public void getMessage4(String message) throws InterruptedException {
        System.out.println(message+"------getMessage4-------"+ LocalDateTime.now());
        Thread.sleep(200);
        return;
    }




    /*@RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "topicQueue"),
                    exchange =@Exchange(name = "topic",type = "topic"),
                    key = {"#.error"}
            )})
    public void getMessage5(String message) {
        System.out.println(message+"------getMessage3-------"+ LocalDateTime.now());
        return;
    }*/


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = "topic.china"),
                    exchange =@Exchange(name = "topic" ,type = "topic"),
                    key = {"#.error"}
            )})
    public void getMessage6(Map<String,Object> message)  {
        System.out.println(message+"------getMessage4-------"+ LocalDateTime.now());
        return;
    }
}
