package se.yrgo;

import java.util.*;

public class Main {
    static void main() {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library("My Library");
        Database database = new Database();
        System.out.println("Welcome to the library system!");

        System.out.println(
                "What do you want to do? (1: Create Account, 2: Remove Your Account, 3: borrow Book, 4: Return Book, 5: Show All Books)");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) { // Create new User
                case 1:
                    System.out.println(
                            "Enter user information: full name, address, email, password, phone number (each on a new line):");
                    User user1 = new User(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextLine(), scanner.nextLine());
                    database.addUser(user1);
                    database.giveCustomerId(user1);

                    showUserInfo(user1);
                    break;
                case 2: // Remove user
                    System.out.println("Enter your customer ID to remove your account:");
                    String customerID = scanner.nextLine();
                    database.removeUser(customerID);
                    System.out.println("Account removed successfully.");
                    break;
                case 3: // Borrow a book
                    library.getBookList().forEach((book, status) -> {
                        System.out.printf("Title: %s, Author: %s, Status: %s%n", book.getTitle(),
                                book.getAuthor(), status);
                    });
                    System.out.println("Enter the title of the book you want to borrow:");
                    String bookTitle = scanner.nextLine();

                    break;
                case 4: // remove a book
                    // Implement return book functionality
                    break;
                case 5: // show all borrowed books of user.
                    // Implement show all books functionality
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
        }

    }

    private static void showUserInfo(User user1) {
        System.out.printf("User added:%nName: %s%nAddress: %s%nEmail: %s%nCustomer ID: %s%nPhone: %s%n",
                user1.getFullName(), user1.getAddress(), user1.getEmail(), user1.getCustomerID(),
                user1.getPhoneNumber());
    }

}
