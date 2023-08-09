package com.parim.view.page.menu;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

import static java.lang.System.exit;

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
        chatroom.addActionListener(e -> MainFrame.getInstance().setChatPage());
        this.add(chatroom);

        ButtonCreator shop = new ButtonCreator(gap + 120*3, "Shop");
        shop.addActionListener(e -> MainFrame.getInstance().setShopPage());
        this.add(shop);

        ButtonCreator scoreboard = new ButtonCreator(gap + 120*4, "Scoreboard");
        scoreboard.addActionListener(e -> MainFrame.getInstance().setScoreboardPage());
        this.add(scoreboard);

        ButtonCreator exit = new ButtonCreator(gap + 120*5, "Exit");
        exit.addActionListener(e -> exit(0));
        this.add(exit);

        ButtonCreator notifications = new ButtonCreator(900, gap, "Notifications");
        notifications.addActionListener(e -> MainFrame.getInstance().requestUserNotifications());
        this.add(notifications);

        ButtonCreator rooms = new ButtonCreator(900, gap + 120, "Rooms");
        rooms.addActionListener(e -> MainFrame.getInstance().setRoomsPage());
        this.add(rooms);

        if (MainFrame.isOfflineGame()) {
            startOnlineGame.setEnabled(false);
            chatroom.setEnabled(false);
            notifications.setEnabled(false);

            ButtonCreator retryConnectToServer = new ButtonCreator(900, gap + 120 * 5, "Connect To Server");
            retryConnectToServer.addActionListener(e -> MainFrame.getInstance().clickedOnTryAgain());
            this.add(retryConnectToServer);
        }

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
