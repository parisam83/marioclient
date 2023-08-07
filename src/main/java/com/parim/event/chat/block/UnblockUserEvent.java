package com.parim.event.chat.block;

import com.parim.event.FormEvent;

public class UnblockUserEvent implements FormEvent {
    private String username;
    public UnblockUserEvent(){}

    public UnblockUserEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
