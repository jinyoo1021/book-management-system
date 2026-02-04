package com.example.bookmanagement.presentation;

public class BookDto {

    private Long isbn;            //International Standard Book Number
    private String title;           //book title
    private String author;          //book author


    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

}
