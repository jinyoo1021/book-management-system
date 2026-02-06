package com.example.bookmanagement.presentation;

import jakarta.validation.constraints.NotNull;

public class BookDto {

    private Long isbn;            //International Standard Book Number

    @NotNull
    private String title;           //book title

    @NotNull
    private String author;          //book author

    @NotNull
    private Integer amount;         //number of copies available


    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

}
