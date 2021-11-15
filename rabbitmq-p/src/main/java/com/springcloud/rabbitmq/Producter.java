package com.springcloud.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/24 11:45
 */
@RestController
@RequestMapping(value = "/rabbit")
public class Producter {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMessage")
    public String helloWorld() {
        for (int i = 1; i < 101; i++) {
            rabbitTemplate.convertAndSend("test","songjing"+i);
        }
        return "消息发送成功";
    }

    @GetMapping("/sendDirectMessage")
    public String directTest() {
        for (int i = 1; i < 101; i++) {
            rabbitTemplate.convertAndSend("direct","info","directQueue"+i);
        }
        return "消息发送成功";
    }

    @GetMapping("/sendTopicMessage")
    public String topicTest() {
        for (int i = 1; i < 101; i++) {
            Map<Integer,Object> param=new HashMap<>();
            param.put(i,"哈哈哈");
            rabbitTemplate.convertAndSend("topic","aaa.error",param);
        }
        return "消息发送成功";
    }
}
