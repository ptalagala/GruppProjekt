package se.yrgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BookTest {
    @Test
    public void newBookStatusAsAvailable(){
        Book book = new Book("Introduction to Java", "K. Philips", "13453984573922",1);
        assertEquals(LoanStatus.AVAILABLE, book.getLoanStatus());
    }

    @Test
    public void testEqualBookCopies(){
        Book book1 = new Book("Introduction to Java Programming","Y. Liang","9781292469966",1);
        Book book2 = new Book("Introduction to Java Programming","Y. Liang","9781292469966",1);
        assertEquals(book1, book2);
    }

    @Test
    public void testUnequalBookCopies(){
        Book book1 = new Book("Introduction to Java Programming","Y. Liang","9781292469966",1);
        Book book2 = new Book("Introduction to Java Programming","Y. Liang","9781292469966",2);
        Book book3 = new Book("Spring Boot: Up and Running", "M. Heckler", "9781492076988",1);
        assertNotEquals(book1, book2);
        assertNotEquals(book1, book3);
    }

    @Test
    public void testUnequalBooks(){
        Book book1 = new Book("Introduction to Java Programming","Y. Liang","9781292469966",1);
        Book book3 = new Book("Spring Boot: Up and Running", "M. Heckler", "9781492076988",1);
        assertNotEquals(book1, book3);
    }
}
