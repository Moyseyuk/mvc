package com.tms.services;

import com.tms.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        String author = rs.getString("author");
        String bookName = rs.getString("name");
        return new Book(id, author, bookName);
    }
}
