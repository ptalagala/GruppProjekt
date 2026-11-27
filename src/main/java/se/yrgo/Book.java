package se.yrgo;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String isbn;
    private int copyNo;
    private LoanStatus loanStatus;

    public Book(String title, String author, String isbn, int copyNo) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copyNo = copyNo;
        this.loanStatus = LoanStatus.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopyNo() {
        return copyNo;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return copyNo == book.copyNo && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, isbn, copyNo);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copyNo=" + copyNo +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}

