package com.parim.model;

import java.util.ArrayList;

public class Chat {
    String username1, username2;
    ArrayList<String> messages = new ArrayList<>();
    public Chat(){}
    public Chat(String username1, String username2){
        this.username1 = username1;
        this.username2 = username2;
    }

    public void addMessage(String from, String message){
        messages.add(from + ": " + message);
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }
}
