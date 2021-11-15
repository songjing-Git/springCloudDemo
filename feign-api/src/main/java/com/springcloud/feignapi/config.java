package com.springcloud.feignapi;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/18 10:15
 */
@Configuration
public class config {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
