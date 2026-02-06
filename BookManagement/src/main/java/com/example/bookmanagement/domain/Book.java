package com.example.bookmanagement.domain;

import java.util.Objects;

public class Book {

    private Long isbn;            //International Standard Book Number
    private String title;           //book title
    private String author;          //book author

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Boolean sameIsbn(Long isbn) {
        return this.isbn.equals(isbn);
    }

    public Boolean containsTitle(String title) {
        return this.title.contains(title);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

}
