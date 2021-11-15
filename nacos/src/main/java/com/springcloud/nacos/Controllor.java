package com.springcloud.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/17 11:46
 */
@RestController
public class Controllor {

    @Autowired
    private config config;

    @GetMapping("loglevel")
    public String getloglevel(){
        return this.config.getLoglevel();
    }
}
