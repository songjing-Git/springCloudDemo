package com.example.userservice;

import com.springcloud.feignapi.clients.FeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/15 16:38
 */

@RestController
@Configuration
public class Coll {


    @Autowired
    FeignClients feignClients;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/o/{name}")
    public String o(@PathVariable String name){
        return "hahah";
    }

    //restful api方式
    @GetMapping("/hello/{name}")
    public String index(@PathVariable String name){
        RestTemplate restTemplate = getRestTemplate();
        String forObject = restTemplate.getForObject("http://orderService/hello/"+name, String.class);
        System.out.println(forObject);
        return "hello!" + name+forObject;
    }


    //feign调用
    @GetMapping("/getName/{name}")
    public String getName(@PathVariable String name){
        return feignClients.getName(name);
    }

}
