package se.yrgo;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int copyNo;

    public Book(String title, String author, String isbn, int copyNo) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copyNo = copyNo;
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copyNo=" + copyNo +
                '}';
    }
}
