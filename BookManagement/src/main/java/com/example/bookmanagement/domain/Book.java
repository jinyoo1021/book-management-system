package com.example.bookmanagement.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Book {

    private Long isbn;            //International Standard Book Number

    @Size(min = 1, max = 100)
    private String title;           //book title

    @Size(min = 1, max = 50)
    private String author;          //book author

    @Max(9_999)
    @Min(0)
    private Integer amount;         //number of copies available

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
