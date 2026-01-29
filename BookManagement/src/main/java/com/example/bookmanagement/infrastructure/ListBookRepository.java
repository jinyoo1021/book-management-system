package com.example.bookmanagement.infrastructure;


import com.example.bookmanagement.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ListBookRepository {

        private List<Book> books = new ArrayList<>();

        public Book add(Book book) {
            books.add(book);
            return book;
        }

        public Book findByIsbn(String isbn) {
            return books.stream()
                    .filter(book -> book.sameIsbn(isbn))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Book not found"));
        }

}
