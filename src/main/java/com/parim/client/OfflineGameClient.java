package com.parim.client;

import com.parim.model.User;

public class OfflineGameClient {
    // TODO
    private static OfflineGameClient instance;
    public OfflineGameClient() {
        instance = this;
    }

    public void sendLoginMessage(User user) {
        // connectToServer.send(new Message("UserLoginEvent", new UserEvent(username, password)));
    }
    public void sendRegisterMessage(User user) {
        // connectToServer.send(new Message("UserLoginEvent", new UserEvent(username, password)));
    }


    public static OfflineGameClient getInstance() {
        return instance;
    }
}
