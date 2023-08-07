package com.parim.view.page;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;
import java.util.ArrayList;

public class ListOfBlockedUsernamesPage extends JPanel {
    private int x, y;
    private final int width = 250, height = 100;
    public ListOfBlockedUsernamesPage(){
        ButtonCreator back = new ButtonCreator(1100, 600, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setChatPage());
        this.add(back);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
    public void showBlockedUsernames(ArrayList<String> blockedUsernames){
        System.out.println(blockedUsernames);
        for (String username : blockedUsernames){
            int index = blockedUsernames.indexOf(username);
            setPosition(index);
            ButtonCreator button = new ButtonCreator(x, y, width, height, username);
            button.addActionListener(e -> MainFrame.getInstance().requestUserMessages(username));
            this.add(button);
        }
    }
    private void setPosition(int index){
        x = (index * width) % MainFrame.getWIDTH();
        y = (index * height) % MainFrame.getHEIGHT();
    }
}
