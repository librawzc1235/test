package com.test.cn.test.mongo.service;


import java.util.List;

import com.test.cn.test.entity.Book;

public interface BookDbService {
    String saveObj(Book book);

    List<Book> findAll();

    Book getBookById(String id);

    Book getBookByName(String name);

    String updateBook(Book book);

    String deleteBook(Book book);

    String deleteBookById(String id);
}
