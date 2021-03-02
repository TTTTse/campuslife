package com.graduationproject.campuslifeservice.BookService;

import com.graduationproject.campuslifedao.BookDao.BookDao;
import com.graduationproject.campuslifedao.BookEntity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-01 23:15
 **/

@Service
public class BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> allBooks(){
        return bookDao.findAll();
    }
}
