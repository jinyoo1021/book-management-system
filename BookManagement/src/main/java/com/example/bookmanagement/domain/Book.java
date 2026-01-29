package com.example.bookmanagement.domain;

public class Book {

    private String isbn;            //International Standard Book Number
    private String title;           //book title
    private String author;          //book author

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean sameIsbn(String isbn) {
        return this.isbn.equals(isbn);
    }
}
