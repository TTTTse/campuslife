package com.graduationproject.campuslifedao.BookDao;

import com.graduationproject.campuslifedao.BookEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookDao extends JpaRepository<Book, Integer> {

}
