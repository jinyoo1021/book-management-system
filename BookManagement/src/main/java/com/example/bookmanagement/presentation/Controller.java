package com.example.bookmanagement.presentation;

import com.example.bookmanagement.Application.BookService;
import com.example.bookmanagement.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private BookService bookService;

    @Autowired
    Controller(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        bookService.add(bookDto);

        return bookDto;
    }

    @RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET)
    public BookDto findBookByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

}
