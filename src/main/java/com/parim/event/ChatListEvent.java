package com.parim.event;

import java.util.ArrayList;

public class ChatListEvent implements FormEvent {
    private ArrayList<String> chatList;
    public ChatListEvent(){}

    public ChatListEvent(ArrayList<String> chatList) {
        this.chatList = chatList;
    }

    public ArrayList<String> getChatList() {
        return chatList;
    }

    public void setChatList(ArrayList<String> chatList) {
        this.chatList = chatList;
    }
}
