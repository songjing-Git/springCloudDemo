package com.springcloud.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/17 11:45
 */
@Component
@RefreshScope
public class config {
    @Value("${useLocalCache}")
    private String loglevel;

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }

    public String getLoglevel() {
        return loglevel;
    }



}
