package com.njupt.software.practice.library.service.impl;

import com.wdd.library.dao.BookMapper;
import com.wdd.library.pojo.Book;
import com.wdd.library.pojo.Category;
import com.wdd.library.service.BookService;
import com.wdd.library.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;



    public PageBean<Book> queryBookPage(Map<String, Object> paramMap) {
        PageBean<Book> pageBean = new PageBean<Book>((Integer) paramMap.get("pageno"),(Integer) paramMap.get("pagesize"));

        Integer startIndex = pageBean.getStartIndex();
        paramMap.put("startIndex",startIndex);
        List<Book> datas = bookMapper.queryList(paramMap);
        pageBean.setDatas(datas);

        Integer totalsize = bookMapper.queryCount(paramMap);
        pageBean.setTotalsize(totalsize);
        return pageBean;
    }


    public List<Category> listCategory() {
        return bookMapper.listCategory();
    }


    public void addBook(Book book) {
        bookMapper.addBook(book);
    }


    public Book selectById(int book_id) {
        return bookMapper.selectById(book_id);
    }


    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }


    public void delBook(int book_id) {
        bookMapper.delBook(book_id);
    }
}
