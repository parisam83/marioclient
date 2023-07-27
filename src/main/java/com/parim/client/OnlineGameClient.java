package com.parim.client;

import com.parim.ConnectToServer;

import java.net.Socket;

public class OnlineGameClient {
    private Socket socket;
    private ConnectToServer connectToServer;
    public OnlineGameClient(Socket socket){
        this.socket = socket;
        connectToServer = new ConnectToServer(socket);
        runOnlineGame();
    }

    private void runOnlineGame() {
        while (!socket.isClosed()){

        }
        // TODO: notify server that client disconnected
    }
}
