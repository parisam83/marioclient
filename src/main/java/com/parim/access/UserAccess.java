package com.parim.access;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.parim.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserAccess {
    ObjectMapper mapper;
    private final String directory = "database/";
    private final File databaseFile = new File(directory);

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
    private int numberOfUsers(){
        if (databaseFile.list() == null) return 0;
        return databaseFile.list().length;
    }
}
