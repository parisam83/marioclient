package com.parim.view.page.room;

import com.parim.client.OnlineGameClient;
import com.parim.model.Room;
import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;
import com.parim.view.swingObjects.LabelCreator;

import javax.swing.*;

public class NormalUserRoomEvent extends JPanel {
    public NormalUserRoomEvent(Room room) {
        int gap = 150;
        LabelCreator label = new LabelCreator("You are a member of this room with id " + room.getId() + "!");
        this.add(label);

        ButtonCreator sendInviteLink = new ButtonCreator(gap, "Send Invite Link");
        sendInviteLink.addActionListener(e -> {
            OnlineGameClient.getInstance().sendInviteLink(JOptionPane.showInputDialog("Who do you want to invite to  this room?"), room);
        });
        this.add(sendInviteLink);

        ButtonCreator back = new ButtonCreator(gap + 120, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
