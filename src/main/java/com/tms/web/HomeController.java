package com.tms.web;

import com.tms.model.Book;
import com.tms.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(){
        return "book";
    }

    @PostMapping("/")
    public String save(@RequestParam("author") String author,
                       @RequestParam("book") String book){
        bookService.save(new Book(UUID.randomUUID(), author, book));
        return "book";
    }

    @PostMapping("/search")
    public String search(@RequestParam("bookSearch") String bookSearch, Model model){
        System.out.println(bookService.searchBook(bookSearch));
        model.addAttribute("bookSearch", bookService.searchBook(bookSearch));
        return "book";
    }
}
