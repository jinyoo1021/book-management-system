package com.example.bookmanagement.infrastructure;


import com.example.bookmanagement.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListBookRepository {

        private List<Book> books = new ArrayList<>();
        private AtomicLong sequence = new AtomicLong(1L);


        public Book add(Book book) {
            book.setIsbn(sequence.getAndAdd(1L));
            books.add(book);
            return book;
        }


        public Book findByIsbn(Long isbn) {
            return books.stream()
                    .filter(book -> book.sameIsbn(isbn))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Book not found"));
        }

}
