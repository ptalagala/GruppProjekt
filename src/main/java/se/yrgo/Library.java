package se.yrgo;

import java.util.*;

public class Library {
    private String libraryName;
    private List<Book> bookList;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookList = new ArrayList<>();
        bookList.add(new Book("Introdcution to Java","R. J. Martin","3556569897897",1));
        bookList.add(new Book("Introdcution to Java","R. J. Martin","3556569897897",2));
        bookList.add(new Book("Introdcution to C#","M. K. Lans","3556569897897",1));
        bookList.add(new Book("Introdcution to C#","M. K. Lans","3556569897897",2));
        bookList.add(new Book("Advanced Coding with Java","P. B. Johnson","3556569897897",1));
        bookList.add(new Book("Linux Bible","C. Negus","3556569897897",1));
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

    public void addNewBook(Book book){
        for(Book existingBook : bookList )
            if (existingBook.equals(book)) {
                System.out.println("Book already exists!");

            } else {
                bookList.add(book);
                System.out.println("Book added!");
            }
    }

    public void removeBook(Book book){
        bookList.remove(book);
        System.out.println("Book removed!");
    }
}
