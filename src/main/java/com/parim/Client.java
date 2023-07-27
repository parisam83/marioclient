package com.parim;

import com.parim.view.MainFrame;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static Client instance;
    private Socket socket;
    private MainFrame mainFrame;
    private ConnectToServer connectToServer;
    private boolean clickedOnTryAgain = true;
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
        }
        System.out.println("TADAAAAA\nConnected!");
    }

    public void tryToConnect() {
        mainFrame.setConnectingPage();
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException e) {
            clickedOnTryAgain = false;
            mainFrame.setFailedConnectionPage();
        }

        /*connectToServer = new ConnectToServer(socket);
        runClient2();*/
    }

    private void runClient2(){
        while (!socket.isClosed()){

        }
        // TODO: notify server that client disconnected
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
    private void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}