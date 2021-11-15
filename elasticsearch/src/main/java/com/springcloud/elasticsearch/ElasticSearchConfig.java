package com.springcloud.elasticsearch;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/30 16:08
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "es")
public class ElasticSearchConfig {

//    @Value("${elasticSearchHost}")
    private String elasticSearchHost;



    //    @Value("${elasticSearchPort}")
    private int elasticSearchPort;

    public String getElasticSearchHost() {
        return elasticSearchHost;
    }

    public int getElasticSearchPort() {
        return elasticSearchPort;
    }

    public void setElasticSearchHost(String elasticSearchHost) {
        this.elasticSearchHost = elasticSearchHost;
    }

    public void setElasticSearchPort(int elasticSearchPort) {
        this.elasticSearchPort = elasticSearchPort;
    }

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        log.info("elasticSearchHost:{} ,elasticSearchPort:{}",elasticSearchHost,elasticSearchPort);
        HttpHost httpHost = new HttpHost(elasticSearchHost, elasticSearchPort);
        RestClientBuilder builder = RestClient.builder(httpHost);
        return new RestHighLevelClient(builder);
    }
}
