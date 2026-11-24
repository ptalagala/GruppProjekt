package se.yrgo;

import java.util.*;

public class Library {
    private String libraryName;

    private List<Book> bookList; // Book, Loan Status
    // private List<User> libraryUser;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookList = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    public void addNewBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }
}
