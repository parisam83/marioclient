package com.parim;

import com.parim.client.OfflineGameClient;
import com.parim.client.OnlineGameClient;
import com.parim.model.User;
import com.parim.view.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private static Client instance;
    private Socket socket;
    private MainFrame mainFrame;
    private boolean offlineGame, onlineGame;
    public Client(){
        if (instance != null) return;
        instance = this;

        mainFrame = new MainFrame();
        clickedOnTryConnectingToServer();
    }

    private void tryToConnect() {
        mainFrame.setConnectingPage();
        Timer timer = new Timer(1000, e -> {
            startConnection();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void startConnection(){
        try {
            socket = new Socket("localhost", 9000);
            runOnlineGame();
        } catch (IOException ex) {
            mainFrame.setFailedConnectionPage();
        }
    }

    private void runOfflineGame(){
        offlineGame = true;
        mainFrame.setAccountPage();
        new OfflineGameClient();
    }
    private void runOnlineGame(){
        onlineGame = true;
        mainFrame.setAccountPage();
        new Thread(() -> new OnlineGameClient(socket)).start();
    }

    public static void main(String[] args) {
        new Client();
    }

    public static Client getInstance() {
        return instance;
    }
    public void clickedOnTryConnectingToServer() {
        tryToConnect();
    }
    public void clickedOnOfflineGame(){
        runOfflineGame();
    }

    public void sendRegisterMessage(User user) {
        if (isOfflineGame()) System.out.println("HugeBug! :: Registration is not disabled in offline game");
        else OnlineGameClient.getInstance().sendRegisterMessage(user);
    }
    public void sendLoginMessage(User user) {
        if (isOfflineGame()) OfflineGameClient.getInstance().sendLoginMessage(user);
        else OnlineGameClient.getInstance().sendLoginMessage(user);
    }


    public void receivedRegisterResult(String result) {
        MainFrame.getInstance().receivedRegisterResult(result);
    }
    public void receivedLoginResult(String result) {
        MainFrame.getInstance().receivedLoginResult(result);
    }
    public boolean isOfflineGame(){
        return offlineGame;
    }
}