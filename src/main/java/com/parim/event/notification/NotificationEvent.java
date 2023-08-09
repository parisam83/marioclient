package com.parim.event.notification;

import com.parim.event.FormEvent;

public class NotificationEvent implements FormEvent {
    String title, message, type;

    public NotificationEvent() {}

    public NotificationEvent(String title, String message, String type) {
        this.title = title;
        this.message = message;
        if (message.length() >= 40) this.message = message.substring(0, 40);
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        if (message.length() >= 40) this.message = message.substring(0, 40);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
