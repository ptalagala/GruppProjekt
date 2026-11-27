package se.yrgo;

import java.util.*;

public class Library {
    private String libraryName;
    private List<Book> bookList;
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

    public List<Book> getBookByStatus(LoanStatus loanStatus) {
        return bookList.stream().filter(book -> book.getLoanStatus() == loanStatus).toList();
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", bookList=" + bookList +
                '}';
    }

    public void addNewBook(Book book) {
        if (!bookList.isEmpty()) {
            for (Book existingBook : bookList)
                if (existingBook.equals(book)) {
                    throw new IllegalArgumentException("Book already exists!");
                }
        }
        bookList.add(book);
        System.out.println("Book added!");
    }

    public void removeBook(Book book) {
        bookList.remove(book);
        System.out.println("Book removed!");
    }
}
