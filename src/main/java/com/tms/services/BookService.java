package com.tms.services;

import com.tms.model.Book;
import com.tms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public void save(Book book){
        repository.save(book);
    }

    public List<Book> getBook(){
        return  repository.getAllBooks();
    }

    public List<Book> searchBook(String searchString){
        List<Book> foundedBooks = new ArrayList<>();
        List<Book> books = repository.getAllBooks();
        for (Book book : books){
            String author = book.getAuthor();
            String name = book.getBookName();
            if (author.contains(searchString) || name.contains(searchString)){
                foundedBooks.add(book);
            }
        }
        return foundedBooks;
    }

}
