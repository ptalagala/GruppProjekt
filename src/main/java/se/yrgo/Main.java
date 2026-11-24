package se.yrgo;

import java.util.*;

public class Main {
    static void main() {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library("My Library");
        Database database = new Database();
        database.loadDatabaseFromJson("database.json");
        System.out.println("Welcome to the library system!");

        final User loggedInUser = logIn(scanner, database);

        // ---- Menu (loggedInUser is set from here on) ----
        System.out.println(
                "What do you want to do? (1: Remove Your Account, 2: Borrow Book, 3: Return Book, 4: Show My Books)");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Remove account
                    break;
                case 2: // Borrow a book
                    library.getBookList().sort(Comparator.naturalOrder());
                    System.out.println("Available books:");
                    for (Book book : library.getBookList()) {
                        if (book.getLoanStatus() == LoanStatus.AVAILABLE) {
                            System.out.println(book);
                        }
                    }
                    System.out.println("Enter the title of the book you want to borrow:");
                    String title = scanner.nextLine();
                    Book bookToBorrow = null;

                    for (Book book : library.getBookList()) {
                        if (book.getTitle().equalsIgnoreCase(title) && book.getLoanStatus() == LoanStatus.AVAILABLE) {
                            bookToBorrow = book;
                            loggedInUser.addBorrowedBook(bookToBorrow);
                            bookToBorrow.setLoanStatus(LoanStatus.BORROWED);
                            System.out.println("You have borrowed: " + bookToBorrow);
                            break;
                        } else {
                            System.out.println("Book not found or not available.");
                            break;
                        }
                    }

                case 3: // Return a book
                    List<Book> borrowedBooks = loggedInUser.getBorrowedBooks();
                    if (borrowedBooks.isEmpty()) {
                        System.out.println("You have no borrowed books to return.");
                    } else {
                        System.out.println("Your borrowed books:");
                        for (Book book : borrowedBooks) {
                            System.out.println(book);
                        }
                        System.out.println("Enter the title of the book you want to return:");
                        String returnTitle = scanner.nextLine();
                        Book bookToReturn = null;
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("You have no borrowed books to return.");
                        } else {
                            for (Book book : borrowedBooks) {
                                if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                                    bookToReturn = book;
                                    loggedInUser.removeBorrowedBook(bookToReturn);
                                    bookToReturn.setLoanStatus(LoanStatus.AVAILABLE);
                                    System.out.println("You have returned: " + bookToReturn);
                                    break;
                                }
                            }
                            if (bookToReturn == null) {
                                System.out.println("Book not found in your borrowed list.");
                            }
                        }
                    }
                    break;
                case 4: // Show my borrowed books
                    List<Book> borrowedBooks = loggedInUser.getBorrowedBooks();
                    if (borrowedBooks.isEmpty()) {
                        System.out.println("You have no borrowed books.");
                    } else {
                        System.out.println("Your borrowed books:");
                        for (Book book : borrowedBooks) {
                            System.out.println(book);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // ---- Log in / create account. Keeps asking until someone is logged in. ----
    private static User logIn(Scanner scanner, Database database) {
        while (true) {
            System.out.println("1: Log in, 2: Create account");
            String start = scanner.nextLine();

            if (start.equals("1")) {
                System.out.println("Customer ID:");
                String id = scanner.nextLine();
                System.out.println("Password:");
                String password = scanner.nextLine();

                User user = database.getUser(id);
                if (user != null && user.getPassword().equals(password)) {
                    System.out.println("Welcome " + user.getFullName() + "!");
                    return user;
                }
                System.out.println("Wrong customer ID or password.");

            } else if (start.equals("2")) {
                System.out.println(
                        "Enter user information: full name, address, email, password, phone number (each on a new line):");
                User newUser = new User(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                        scanner.nextLine(), scanner.nextLine());
                database.giveCustomerId(newUser); // ID first...
                database.addUser(newUser); // ...then add, so it's stored under the right key

                System.out.println("Account created! Your customer ID is: " + newUser.getCustomerID());
                System.out.println("Welcome " + newUser.getFullName() + "!");
                return newUser; // logged in straight away
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void showUserInfo(User user1) {
        System.out.printf("User added:%nName: %s%nAddress: %s%nEmail: %s%nCustomer ID: %s%nPhone: %s%n",
                user1.getFullName(), user1.getAddress(), user1.getEmail(), user1.getCustomerID(),
                user1.getPhoneNumber());
    }
}
