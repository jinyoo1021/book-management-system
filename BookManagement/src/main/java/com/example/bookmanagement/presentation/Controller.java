package com.example.bookmanagement.presentation;

import com.example.bookmanagement.Application.BookService;
import com.example.bookmanagement.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private BookService bookService;

    @Autowired
    Controller(BookService bookService) {
        this.bookService = bookService;
    }

    // Create a new book
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    // Get book by ISBN
    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
    public BookDto findBookByIsbn(@PathVariable Long isbn) {
        return bookService.findByIsbn(isbn);
    }

    // Get all books
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<BookDto> findAllBooks() {
        return bookService.findAll();
    }
}
