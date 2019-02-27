package com.encore.wikidemo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.encore.wikidemo.client.ElasticSearchClient;
import com.encore.wikidemo.model.SearchResult;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WikiDemoApplicationTests {

    @Autowired
    private ElasticSearchClient elasticSearchClient;

    @Test
    public void contextLoads() throws IOException {
        for (SearchResult r : elasticSearchClient.search("안성시")) {
            System.out.println(r.getTitle());
        }
        for (SearchResult r : elasticSearchClient.search("즐라탄")) {
            System.out.println(r.getTitle());
        }
        System.out.println();
    }
}
