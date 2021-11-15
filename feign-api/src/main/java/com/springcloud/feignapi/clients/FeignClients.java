package com.springcloud.feignapi.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/17 15:44
 */
@FeignClient("orderService")
public interface FeignClients {

    @GetMapping("/hello/{name}")
     String getName(@PathVariable("name") String name);
}
