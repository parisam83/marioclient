package com.parim.event.chat.message;

import com.parim.event.FormEvent;
import com.parim.model.Chat;

public class MessageEvent implements FormEvent {
    private Chat chat;
    public MessageEvent(){}
    public MessageEvent(Chat chat){
        this.chat = chat;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}