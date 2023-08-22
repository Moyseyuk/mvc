package com.tms.repository;

import com.tms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookRepository {

    public static final String SAVE_SQL = "insert into books (id, author, name) values (?, ? ,?)";
    public static final String GETALL_SQL = "select * from books";

    @Autowired
    private Connection connection;

    public void save(Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL);
        preparedStatement.setString(1, book.getId().toString());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setString(3, book.getBookName());
        boolean execute = preparedStatement.execute();
        preparedStatement.close();
    }

    public List<Book> getBooks() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(GETALL_SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        return getAllBooks(resultSet, preparedStatement);
    }

    private List<Book> getAllBooks(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        List<Book> books = new ArrayList<Book>();

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String author = resultSet.getString("author");
            String name = resultSet.getString("name");
            Book book = new Book(UUID.fromString(id), author, name);
            books.add(book);
        }
        preparedStatement.close();
        return books;
    }

}
