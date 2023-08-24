package com.tms.repository;

import com.tms.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookRepository {

    private final JdbcTemplate template;
    private final RowMapper<Book> rowMapper;

    public void save(Book book){
        template.update("insert into books (id, author, name) VALUES (?, ?, ?)", book.getId().toString(), book.getAuthor(), book.getBookName());
    }

    public List<Book> getAllBooks(){
        List<Book> books = template.query("select * from books", rowMapper);
        return books;
    }

}
