package com.parim.client;

import com.parim.Client;
import com.parim.ConnectToServer;
import com.parim.access.UserAccess;
import com.parim.event.Message;
import com.parim.event.UserEvent;
import com.parim.model.User;

import java.net.Socket;

public class OnlineGameClient {
    private static OnlineGameClient instance;
    private Socket socket;
    private ConnectToServer connectToServer;
    private UserAccess userAccess = new UserAccess();
    public OnlineGameClient(Socket socket){
        instance = this;

        this.socket = socket;
        connectToServer = new ConnectToServer(socket);
        runOnlineGame();
    }

    private void runOnlineGame() {
        while (!socket.isClosed()){
            Message serverRespond =connectToServer.receive();
            String title = serverRespond.getTitle();
            if (title.equals("UserRegisterSuccessful")) receivedUserRegisterSuccessful();
            if (title.equals("UserRegisterUnsuccessful")) receivedUserRegisterUnsuccessful();
            if (title.equals("UserLoginSuccessful")) receivedUserLoginSuccessful();
            if (title.equals("UserLoginUnsuccessful")) receivedUserLoginUnsuccessful();
        }
        connectToServer.send(new Message("ClientClosedEvent", null)); // notifies server that client disconnected
    }

    public void sendRegisterMessage(User user) {
        userAccess.add(user);
        connectToServer.send(new Message("UserRegisterEvent", new UserEvent(user)));
    }
    public void sendLoginMessage(User user) {
        connectToServer.send(new Message("UserLoginEvent", new UserEvent(user)));
    }
    private void receivedUserRegisterSuccessful(){
        Client.getInstance().receivedRegisterResult("yes");
    }
    private void receivedUserRegisterUnsuccessful() {
        Client.getInstance().receivedRegisterResult("no");
    }
    private void receivedUserLoginSuccessful(){
        Client.getInstance().receivedLoginResult("yes");
    }
    private void receivedUserLoginUnsuccessful() {
        Client.getInstance().receivedLoginResult("no");
    }

    public static OnlineGameClient getInstance() {
        return instance;
    }
}
