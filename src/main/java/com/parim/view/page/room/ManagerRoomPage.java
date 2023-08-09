package com.parim.view.page.room;

import com.parim.client.OnlineGameClient;
import com.parim.model.Room;
import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;
import com.parim.view.swingObjects.LabelCreator;

import javax.swing.*;

public class ManagerRoomPage extends JPanel {
    public ManagerRoomPage(Room room){
        int gap = 150;
        LabelCreator label = new LabelCreator("You are the manager of this room with id " + room.getId() + "!");
        this.add(label);

        ButtonCreator sendInviteLink = new ButtonCreator(gap, "Send Invite Link");
        sendInviteLink.addActionListener(e -> OnlineGameClient.getInstance().sendInviteLink(JOptionPane.showInputDialog("Who do you want to invite to  this room?"), room));
        this.add(sendInviteLink);

        ButtonCreator removeUser = new ButtonCreator(gap + 120, "Remove user");
        removeUser.addActionListener(e -> MainFrame.getInstance().removeUserFromRoom(JOptionPane.showInputDialog("Who do you want to invite to  this room?"), room));
        this.add(removeUser);

        ButtonCreator setNewAssistant = new ButtonCreator(gap + 120*2, "Set New Assistant");
        setNewAssistant.addActionListener(e -> OnlineGameClient.getInstance().setNewAssistant(JOptionPane.showInputDialog("Who do you want to set as new assistant?"), room));
        this.add(setNewAssistant);

        ButtonCreator runGame = new ButtonCreator(gap + 120*3, "Run Game");
        runGame.addActionListener(e -> OnlineGameClient.getInstance().runRoomGame(room));
        this.add(runGame);

        ButtonCreator back = new ButtonCreator(gap + 120*4, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
