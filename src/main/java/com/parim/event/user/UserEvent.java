package com.parim.event.user;

import com.parim.event.FormEvent;
import com.parim.model.User;

public class UserEvent implements FormEvent {
    private User user;
    public UserEvent(){}
    public UserEvent(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
