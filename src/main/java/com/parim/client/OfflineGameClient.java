package com.parim.client;

import com.parim.Client;
import com.parim.access.UserAccess;
import com.parim.model.User;

public class OfflineGameClient {
    private static OfflineGameClient instance;
    public OfflineGameClient() {
        instance = this;
    }

    public void sendLoginMessage(User user) {
        if (UserAccess.getInstance().find(user)) Client.getInstance().receivedLoginResult("yes");
        else Client.getInstance().receivedLoginResult("no");
    }


    public static OfflineGameClient getInstance() {
        return instance;
    }
}
