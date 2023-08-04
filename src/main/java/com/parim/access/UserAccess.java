package com.parim.access;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.parim.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserAccess {
    private static UserAccess instance;
    ObjectMapper mapper;
    private final String directory = "database/";
    private final File databaseFile = new File(directory);
    private ArrayList<User> users = new ArrayList<>();

    public UserAccess(){
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public void add(User user){
        try {
            mapper.writeValue(new FileWriter(directory + "user" + String.valueOf(numberOfUsers() + 1) + ".json"), user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read(){
        users.clear();
        for (int i = 1; i <= numberOfUsers(); i++) {
            try {
                File file1 = new File(directory + "user" + String.valueOf(i) + ".json");
                User newUser = mapper.readValue(file1, User.class);
                users.add(newUser);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean find(User wantingUser){
        String username = wantingUser.getUsername(), password = wantingUser.getPassword();
        read();
        for (User user : users)
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        return false;
    }
    private int numberOfUsers(){
        if (databaseFile.list() == null) return 0;
        return databaseFile.list().length;
    }

    public static UserAccess getInstance() {
        if (instance == null) instance = new UserAccess();
        return instance;
    }
}
