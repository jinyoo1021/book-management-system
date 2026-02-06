package com.example.bookmanagement.infrastructure;


import com.example.bookmanagement.domain.Book;
import com.example.bookmanagement.domain.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListBookRepository {

        private List<Book> books = new ArrayList<>();
        private AtomicLong sequence = new AtomicLong(1L);

        // Add a new book
        public Book add(Book book) {
            book.setIsbn(sequence.getAndAdd(1L));
            books.add(book);
            return book;
        }

        // Find book by ISBN
        public Book findByIsbn(Long isbn) {
            return books.stream()
                    .filter(book -> book.sameIsbn(isbn))
                    .findFirst()
                    .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        }

        // Find all books
        public List<Book> findAll() {
            return books;
        }

        // Find books by title
        public List<Book> findByTitle(String title) {
            return books.stream()
                    .filter(book -> book.containsTitle(title))
                    .toList();
        }

        // Update book
        public Book update(Book updatedBook) {
            Integer indexToModify = books.indexOf(updatedBook);
            books.set(indexToModify, updatedBook);
            return updatedBook;
        }

        // Delete book by ISBN
        public void delete(Long isbn) {
            Book book = this.findByIsbn(isbn);
            books.remove(book);
        }
}
