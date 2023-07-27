package com.parim.client;

import com.parim.Client;
import com.parim.ConnectToServer;
import com.parim.event.Message;
import com.parim.event.UserEvent;

import java.net.Socket;

public class OnlineGameClient {
    private static OnlineGameClient instance;
    private Socket socket;
    private ConnectToServer connectToServer;
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

    public void sendRegisterMessage(String username, String password) {
        connectToServer.send(new Message("UserRegisterEvent", new UserEvent(username, password)));
    }
    public void sendLoginMessage(String username, String password) {
        connectToServer.send(new Message("UserLoginEvent", new UserEvent(username, password)));
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
