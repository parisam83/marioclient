package com.parim.event.chat.block;

import com.parim.event.FormEvent;

public class BlockUserEvent implements FormEvent {
    private String username;
    public BlockUserEvent(){}

    public BlockUserEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
