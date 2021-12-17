package com.sun.demo;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.sun.demo.entity.Book;
import com.sun.demo.repository.BookRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.ParsedAvg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙洪波
 * @version 1.0
 * @description ES test
 * @date 2021/9/17
 **/
@SpringBootTest
public class EsRestTemplateTest {
    //自动注入即可使用
    @Autowired
    private ElasticsearchRestTemplate esRestTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSaveBook() {
        Book book =new Book();
        book.setId(1);
        book.setPrice(BigDecimal.valueOf(100.00));
        book.setTitle("elasticsearch");
        Object  obj = esRestTemplate.save(book);
        Assertions.assertNotNull(obj);
        System.out.println(obj.toString());
    }

    @Test
    void testSaveMutiBook() {
        List<Book> books =new ArrayList<Book>();
        for (int i = 0; i < 1000; i++) {
            int num =i+1;
            Book book =new Book();
            book.setId(i+2);
            book.setPrice(BigDecimal.valueOf(i+100.00));
            book.setTitle("elasticsearch book "+num);
            List<String> tags =new ArrayList<String>();
            tags.add("描述:"+num);
            tags.add("标签:"+num);
            tags.add("分类:"+(num%10));
            book.setTag(tags);
            books.add(book);
        }
        Object  obj = esRestTemplate.save(books);
        Assertions.assertNotNull(obj);
        System.out.println(obj.toString());
    }


    //按id查询
    @Test
    void testQueryBookById() {
        Book book = esRestTemplate.get("1", Book.class);
        Assertions.assertNotNull(book);
        System.out.println(book.toString());
    }

    //按书名查询
    @Test
    void testQueryBookByTitle() {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("title", "elasticsearch"))
                .build();
        SearchHits<Book> searchHits = esRestTemplate.search(searchQuery, Book.class);
        System.out.println("查询结果数："+searchHits.get().count());
        //SearchHits就是查询的结果集
        searchHits.get().forEach(hit -> {
            System.out.println(hit.getContent());
        });
    }

    //聚合操作-计算所有书籍的平均价格
    @Test
    void testAggregationBookAvgPrice() {
        //聚合名为avg_price，对price字段进行聚合，计算平均值
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .addAggregation(AggregationBuilders.avg("avg_price").field("price"))
                .build();
        SearchHits<Book> searchHits = esRestTemplate.search(searchQuery, Book.class);
        searchHits.get().forEach(hit -> {
            System.out.println(hit.getContent());
        });
        //获取聚合结果
        if (searchHits.hasAggregations()) {
            ParsedAvg parsedAvg = searchHits.getAggregations().get("avg_price");
            Assertions.assertNotNull(parsedAvg, "无聚合结果");
            System.out.println(parsedAvg.getValue());
        }
    }

    @Test
    void testFindByPriceBetween() {
        List<Book> books = bookRepository.findByPriceBetween(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        if(CollectionUtils.isNotEmpty(books)){
            System.out.println(books.size());
        }
    }

    @Test
    void testFindByTitle() {
        List<Book> books = bookRepository.findByTitle("elasticsearch book");
        if(CollectionUtils.isNotEmpty(books)){
            System.out.println(books.size());
        }
    }

    @Test
    void TestFindByTagIn(){
        List<String> tags =new ArrayList<>(2);
        // tags.add("描述:");
        tags.add("分类:1");
        List<Book> books = bookRepository.findByTagIn(tags);
        if(CollectionUtils.isNotEmpty(books)){
            System.out.println(books.size());
        }
    }
}

