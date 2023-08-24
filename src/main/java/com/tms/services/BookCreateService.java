package com.tms.services;

import com.tms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCreateService {

    @Autowired
    BookService bookService;

    public void create(Book createdBook){
        List<Book> bookList = bookService.getBook();
        for (Book book : bookList){
            if (book.getAuthor().equals(createdBook.getAuthor()) && book.getBookName().equals(createdBook.getBookName())){
                throw new RuntimeException("That book already exist");
            }
        }
    }

}
