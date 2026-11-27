package se.yrgo;

import java.util.*;

public class Library {
    private String libraryName;
    private List<Book> bookList;
    // private List<User> libraryUser;


    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookList = new ArrayList<>();
        bookList.add(new Book("Introduction to Java Programming","Y. Liang","9781292469966",1));
        bookList.add(new Book("Introduction to Java Programming","Y. Liang","9781292469966",2));
        bookList.add(new Book("The C++ Programming Language","B. Stroustrup","9780321563842",1));
        bookList.add(new Book("The C++ Programming Language","B. Stroustrup","9780321563842",2));
        bookList.add(new Book("Spring Boot: Up and Running","M. Heckler","9781492076988",1));
        bookList.add(new Book("Linux Bible","C. Negus","3556569897897",1));
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

    public void addNewBook(Book book){
        for(Book existingBook : bookList )
            if (existingBook.equals(book)) {
                System.out.println("Book already exists!");

            } else {
                bookList.add(book);
                System.out.println("Book added!");
            }

    }

    public void removeBook(Book book) {
        bookList.remove(book);
        System.out.println("Book removed!");
    }
}
