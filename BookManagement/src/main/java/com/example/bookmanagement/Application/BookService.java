package com.example.bookmanagement.Application;
import com.example.bookmanagement.domain.Book;
import com.example.bookmanagement.infrastructure.ListBookRepository;
import com.example.bookmanagement.presentation.BookDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private ListBookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    BookService(ListBookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    // Add a new book
    public BookDto add(BookDto bookDto) {
        // 1. Convert BookDto to Book entity
        Book book = modelMapper.map(bookDto, Book.class);

        // 2. Call repository to add the book
        Book savedBook = bookRepository.add(book);

        // 3. Convert Book entity back to BookDto
        BookDto savedBookDto = modelMapper.map(savedBook, BookDto.class);

        return savedBookDto;
    }

    // Find book by ISBN
    public BookDto findByIsbn(Long isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }

    // Find all books
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = books.stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .toList();
        return bookDtos;
    }
}
