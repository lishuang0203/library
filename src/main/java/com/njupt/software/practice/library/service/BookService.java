package com.njupt.software.practice.library.service;


import com.njupt.software.practice.library.pojo.Book;
import com.njupt.software.practice.library.pojo.Category;
import com.njupt.software.practice.library.util.PageBean;

import java.util.List;
import java.util.Map;

public interface BookService {

    PageBean<Book> queryBookPage(Map<String, Object> paramMap);

    List<Category> listCategory();

    void addBook(Book book);

    Book selectById(int book_id);

    void updateBook(Book book);

    void delBook(int book_id);
}
