package com.parim.model;

import java.util.ArrayList;

public class Room {
    private String id, password, boss;
    private ArrayList<String> assistants, blockedUsers, members;

    public Room() {}

    public Room(String password) {
        this.password = password;
    }

    public Room(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public ArrayList<String> getAssistants() {
        return assistants;
    }

    public void setAssistants(ArrayList<String> assistants) {
        this.assistants = assistants;
    }

    public ArrayList<String> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(ArrayList<String> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
}