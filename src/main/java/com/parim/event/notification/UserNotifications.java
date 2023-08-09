package com.parim.event.notification;

import com.parim.event.FormEvent;

import java.util.ArrayList;

public class UserNotifications implements FormEvent {
    private ArrayList<NotificationEvent> notifications;
    public UserNotifications(){}

    public UserNotifications(ArrayList<NotificationEvent> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<NotificationEvent> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<NotificationEvent> notifications) {
        this.notifications = notifications;
    }
}
