package se.yrgo;

import java.util.ArrayList;

public class User {
    private String fullName;
    private String address;
    private String email;
    private String customerID;
    private String password;
    private String phoneNumber;
    private ArrayList<Book> borrowedBooks;

    public User(String fullName, String address, String email, String password, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

}
