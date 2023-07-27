package com.parim.view.page;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class MenuPage extends JPanel {
    public MenuPage(){
        int gap = 50;
        ButtonCreator startOnlineGame = new ButtonCreator(gap, "Start Online Game");
        //startOnlineGame.addActionListener(e -> MainFrame.getInstance().);
        this.add(startOnlineGame);

        ButtonCreator startOfflineGame = new ButtonCreator(gap + 120, "Start Offline Game");
        //startOnlineGame.addActionListener(e -> MainFrame.getInstance().);
        this.add(startOfflineGame);

        ButtonCreator chatroom = new ButtonCreator(gap + 120*2, "Chat Room");
        //startOnlineGame.addActionListener(e -> MainFrame.getInstance().);
        this.add(chatroom);

        ButtonCreator shop = new ButtonCreator(gap + 120*3, "Shop");
        //startOnlineGame.addActionListener(e -> MainFrame.getInstance().);
        this.add(shop);

        ButtonCreator scoreboard = new ButtonCreator(gap + 120*4, "Scoreboard");
        //startOnlineGame.addActionListener(e -> MainFrame.getInstance().);
        this.add(scoreboard);

        ButtonCreator retryConnectToServer = new ButtonCreator(gap + 120*5, "Connect To Server");
        //startOnlineGame.addActionListener(e -> MainFrame.getInstance().);
        this.add(retryConnectToServer);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
