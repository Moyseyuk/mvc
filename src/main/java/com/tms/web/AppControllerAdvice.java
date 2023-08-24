package com.tms.web;

import com.tms.model.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String exceptionAdvice(RuntimeException exception, Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("error", exception.getMessage());
        return "book";
    }

}
