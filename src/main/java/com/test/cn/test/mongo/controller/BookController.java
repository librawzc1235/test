package com.test.cn.test.mongo.controller;

import org.springframework.web.bind.annotation.*;

import com.test.cn.test.entity.Book;
import com.test.cn.test.mongo.service.BookDbService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by VULCAN on 2019/1/25.
 */

@RestController
public class  BookController{

        @Resource
        private BookDbService bookDbService;

        @RequestMapping("/mongo/save")
        public String saveObj(String id,String name,int price) {
                Book book = new Book();
                book.setCreateTime(new Date());
                book.setUpdateTime(new Date());
                book.setId(id);
                book.setInfo("info");
                book.setPrice(price);
                book.setPublish("publish");
                return bookDbService.saveObj(book);
        }

        @RequestMapping("/mongo/findAll")
        public List<Book> findAll() {return bookDbService.findAll();}

        @RequestMapping("/mongo/findOne")
        public Book findOne(String id) {return bookDbService.getBookById(id);}

        @RequestMapping("/mongo/findOneByName")
        public Book findOneByName(String name) {return bookDbService.getBookByName(name);}

        @RequestMapping("/mongo/update")
        public String update(@RequestBody Book book) {return bookDbService.updateBook(book);}



        @RequestMapping("/mongo/delById")
        public String delById(@RequestParam String id) {return bookDbService.deleteBookById(id);}


}
