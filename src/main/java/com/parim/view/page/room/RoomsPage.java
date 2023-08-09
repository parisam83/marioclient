package com.parim.view.page.room;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;

public class RoomsPage extends JPanel {
    public RoomsPage(){
        ButtonCreator create = new ButtonCreator(450, 350, "Create new room");
        create.addActionListener(e -> {
            Object[] options = {"Done", "I don't wanna set password"};

            JPanel panel = new JPanel();
            panel.add(new JLabel("Please enter the password of the room"));
            JTextField textField = new JTextField(10);
            panel.add(textField);

            int result = JOptionPane.showOptionDialog(null, panel, "Create a new room",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, null);

            if (textField.getText() != null) MainFrame.getInstance().createNewRoom(textField.getText());
        });
        this.add(create);

        ButtonCreator join = new ButtonCreator(800, 350, "Join a room");
        join.addActionListener(e -> {
            Object[] options = {"Join the room", "Cancel"};

            JPanel panel = new JPanel();
            JTextField id = new JTextField(10), password = new JTextField(10);
            panel.add(new JLabel("id: "));
            panel.add(id);
            panel.add(new JLabel("password: "));
            panel.add(password);

            int result = JOptionPane.showOptionDialog(null, panel, "Join a room",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, null);

            if (id.getText() != null) MainFrame.getInstance().joinRoom(id.getText(), password.getText());
        });
        this.add(join);

        ButtonCreator back = new ButtonCreator(100, 650, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
}
