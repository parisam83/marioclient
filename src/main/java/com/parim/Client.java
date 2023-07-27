package com.parim;

import com.parim.client.OfflineGameClient;
import com.parim.client.OnlineGameClient;
import com.parim.view.MainFrame;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static Client instance;
    private Socket socket;
    private MainFrame mainFrame;
    private boolean clickedOnTryAgain = true, clickedOnOfflineGame = false;
    private OnlineGameClient onlineGameClient;
    public Client(){
        if (instance != null) return;
        instance = this;

        mainFrame = new MainFrame();
        runClient();
    }

    public void runClient() {
        while (socket == null) {
            sleep(1000);
            if (clickedOnTryAgain)
                tryToConnect();
            if (clickedOnOfflineGame){
                runOfflineGame();
                break;
            }
        }
        runOnlineGame();
    }

    public void tryToConnect() {
        mainFrame.setConnectingPage();
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException e) {
            clickedOnTryAgain = false;
            mainFrame.setFailedConnectionPage();
        }
    }

    private void runOfflineGame(){
        new OfflineGameClient();
    }
    private void runOnlineGame(){
        // TODO
        mainFrame.setAccountPage();
        onlineGameClient = new OnlineGameClient(socket);
    }

    public static void main(String[] args) {
        new Client();
    }

    public static Client getInstance() {
        return instance;
    }
    public void clickedOnOnlineGame() {
        clickedOnTryAgain = true;
    }
    public void clickedOnOfflineGame(){
        clickedOnOfflineGame = true;
    }
    private void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendRegisterMessage(String username, String password) {
        onlineGameClient.sendRegisterMessage(username, password);
    }

    public void receivedRegisterResult(String result) {
        MainFrame.getInstance().receivedRegisterResult(result);
    }
}