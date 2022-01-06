package com.sun.demo.repository;

import com.sun.demo.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jackson
 * @version 1.0
 * @description
 * @date 2021/9/17
 **/
@Repository
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    //findById()和save()之类的方法父接口已经写了，这里无需重复编写

    /**
     * 按价格区间查询
     * @param min
     * @param max
     * @return
     */
    List<Book> findByPriceBetween(BigDecimal min, BigDecimal max);

    /**
     * 按书名查询，因为使用了中文分词器ik，所以这里并不是精确查询
     * @param title
     * @return
     */
    List<Book> findByTitle(String title);

    /**
     * 按标签匹配查询
     * @param tags
     * @return
     */
    List<Book> findByTagIn(List<String> tags);
}
