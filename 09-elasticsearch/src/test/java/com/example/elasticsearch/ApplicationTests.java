package com.example.elasticsearch;

import com.example.elasticsearch.elasticsearch.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    /**
     * elasticsearch有两种操作方式，一种是springboot自带的spring-data，另一个是Jest(默认不生效)
     */
    @Autowired
    JestClient jestClient;

    /**
     * 索引数据
     */
    @Test
    public void addES() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("ElasticSearch");
        article.setContent("Hello World");
        /**
         * 构建索引
         * index:相当于数据库
         * type：相当于表名
         */
        Index index = new Index.Builder(article).index("wcs").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询表达式搜索数据
     */
    @Test
    public void getES() {
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"Hello World\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(query).addIndex("wcs").addType("news").build();
        try {
            io.searchbox.core.SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用spring-data操作有两种方式，一种是继承ElasticsearchRepository使用
    //可能存在springboot与elasticsearch版本不适配问题
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Test
//    public void springDataAddEs() {
//        Book book = new Book();
//        book.setId(1);
//        book.setName("Golden Without");
//        bookRepository.index(book);
//    }


}

