package com.tms.web;

import com.tms.model.Book;
import com.tms.services.BookCreateService;
import com.tms.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.UUID;

@Controller
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private BookService bookService;
    @Autowired
    private final BookCreateService bookCreateService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/book")
    public String save(@Valid Book book, BindingResult result, Model model){
        bookCreateService.create(book);
        if (!result.hasErrors()){
            bookService.save(new Book(UUID.randomUUID(), book.getAuthor(), book.getBookName()));
        }
        return "book";
    }

    @PostMapping("/")
    public String search(@RequestParam("bookSearch") String bookSearch, Model model){
        System.out.println(bookService.searchBook(bookSearch));
        model.addAttribute("book", new Book());
        model.addAttribute("bookSearch", bookService.searchBook(bookSearch));
        return "book";
    }
}
