package com.spring.cloud.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/15 16:38
 */
@RestController
public class OrderColl {

    @GetMapping("/hello/{name}")
    public String index(@PathVariable String name){
        return "hello!" + name;
    }
}
