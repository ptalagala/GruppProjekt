package se.yrgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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

    public User getUser(String customerID) {
        return users.get(customerID);
    }

    public void giveCustomerId(User user) {
        int n = users.size() + 1;
        while (users.containsKey("CUST" + n)) {
            n++;
        }
        user.setCustomerID("CUST" + n);
    }

    public void saveDatabaseAsJson() {
        saveDatabaseAsJson("database.json");
    }

    public void loadDatabaseFromJson(String fileName) {
        Gson gson = new Gson();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            Type type = new TypeToken<HashMap<String, User>>() {
            }.getType();
            HashMap<String, User> loaded = gson.fromJson(reader, type);
            users.clear();
            if (loaded != null) {
                users.putAll(loaded);
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
