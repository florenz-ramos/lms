package com.sky.lms.models;

public class Book {
    private int bookId;
    private String bookName;
    private String description;
    private String isbn;

    public Book(int bookId, String bookName,String description,String isbn){
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.isbn = isbn;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
