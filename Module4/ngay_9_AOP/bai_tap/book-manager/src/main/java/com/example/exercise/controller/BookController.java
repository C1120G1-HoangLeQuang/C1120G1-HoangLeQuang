package com.example.exercise.controller;

import com.example.exercise.model.Book;
import com.example.exercise.service.BookService;
import com.example.exercise.service.QuantityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public ModelAndView getBookList() {
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("bookList", this.bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/book/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("books", new Book());
        return modelAndView;
    }

    @PostMapping("/book/save")
    public String createNewBook(Book book) {
        this.bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/book/borrow")
    public ModelAndView showBorrowFrom(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("book/borrow");
        modelAndView.addObject("books", this.bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/book/updateBorrow")
    public String saveBook(Book book) throws QuantityException {
        this.bookService.saveBorrow(book);
        return "redirect:/book";
    }

    @ExceptionHandler(QuantityException.class)
    public ModelAndView showNumBookIsOver() {
        return new ModelAndView("book/viewException");
    }

    @GetMapping("/book/return")
    public ModelAndView showReturnFrom(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("book/return");
        modelAndView.addObject("books", this.bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/book/updateReturn")
    public String saveReturnBook(Book book) {
        this.bookService.saveReturn(book);
        return "redirect:/book";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String showErrorPage(){
        return "error";
    }
}
