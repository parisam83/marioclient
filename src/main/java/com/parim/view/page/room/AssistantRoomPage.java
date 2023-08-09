package com.parim.view.page.room;

import com.parim.client.OnlineGameClient;
import com.parim.model.Room;
import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;
import com.parim.view.swingObjects.LabelCreator;

import javax.swing.*;

public class AssistantRoomPage extends JPanel {
    public AssistantRoomPage(Room room) {
        int gap = 150;
        LabelCreator label = new LabelCreator("You are an assistant of this room with id " + room.getId() + "!");
        this.add(label);

        ButtonCreator sendInviteLink = new ButtonCreator(gap, "Send Invite Link");
        sendInviteLink.addActionListener(e -> {
            OnlineGameClient.getInstance().sendInviteLink(JOptionPane.showInputDialog("Who do you want to invite to  this room?"), room);
        });
        this.add(sendInviteLink);

        ButtonCreator removeUser = new ButtonCreator(gap + 120, "Remove user");
        removeUser.addActionListener(e -> {
            MainFrame.getInstance().removeUserFromRoom(JOptionPane.showInputDialog("Who do you want to invite to  this room?"), room);
        });
        this.add(removeUser);

        ButtonCreator back = new ButtonCreator(gap + 120*2, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
