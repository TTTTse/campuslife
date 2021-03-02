package com.graduationproject.campuslifeweb.BookController;

import com.graduationproject.campuslifedao.BookEntity.Book;
import com.graduationproject.campuslifeservice.BookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-01 23:23
 **/

@RestController
public class HelloController {

    @Autowired
    BookService bookService;

    @GetMapping("test")
    public List<Book> test(){
        return bookService.allBooks();
    }
}
