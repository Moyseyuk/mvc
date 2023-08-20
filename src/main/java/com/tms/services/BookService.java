package com.tms.services;

import com.tms.model.Book;
import com.tms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    @SneakyThrows
    public void save(Book book){
        repository.save(book);
    }

    @SneakyThrows
    public List<Book> getBook(){
        return  repository.getBooks();
    }

    @SneakyThrows
    public List<Book> searchBook(String searchString){
        List<Book> foundedBooks = new ArrayList<>();
        List<Book> books = repository.getBooks();
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
