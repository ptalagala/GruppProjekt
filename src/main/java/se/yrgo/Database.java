package se.yrgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Database {

    private HashMap<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getCustomerID(), user);
        saveDatabaseAsJson();
    }

    public void removeUser(String customerID) {
        users.remove(customerID);
        saveDatabaseAsJson();
    }

    public void getUsers() {
        for (User user : users.values()) {
            System.out.printf("Name: %s%nAddress: %s%nEmail: %s%nCustomer ID: %s%nPhone: %s%n",
                    user.getFullName(), user.getAddress(), user.getEmail(), user.getCustomerID(),
                    user.getPhoneNumber());
        }
    }

    public void giveCustomerId(User user) {
        String customerID = "CUST" + (users.size() + 1);
        user.setCustomerID(customerID);
    }

    public void saveDatabaseAsJson() {
        saveDatabaseAsJson("database.json");
    }

    public void loadDatabaseFromJson(String fileName) {
        Gson gson = new Gson();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            User[] loadedUsers = gson.fromJson(reader, User[].class);
            users.clear();
            for (User user : loadedUsers) {
                users.put(user.getCustomerID(), user);
            }
            System.out.println("Database loaded from " + fileName);
        } catch (IOException e) {
            System.out.println("Could not load database: " + e.getMessage());
        }
    }

    public void saveDatabaseAsJson(String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        try (Writer writer = Files.newBufferedWriter(Path.of(fileName))) {
            gson.toJson(users, writer);
            System.out.println("Database saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Could not save database: " + e.getMessage());
        }
    }

}
