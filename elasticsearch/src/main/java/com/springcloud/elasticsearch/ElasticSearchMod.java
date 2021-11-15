package com.springcloud.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/9/30 16:41
 */
@Slf4j
@Controller
public class ElasticSearchMod {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @GetMapping("/index")
    public void testMatchAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest("myindex");
        searchRequest.source().query(QueryBuilders.matchAllQuery());
        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search);
    }
}
