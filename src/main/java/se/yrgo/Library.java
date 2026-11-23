package se.yrgo;

import java.util.*;

public class Library {
    private String libraryName;
    private Map<Book,LoanStatus> bookList; //Book, Loan Status
   // private List<User> libraryUser;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookList = new TreeMap<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Map<Book, LoanStatus> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
