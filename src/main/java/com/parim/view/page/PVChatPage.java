package com.parim.view.page;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PVChatPage extends JPanel {
    public PVChatPage(String me, String theOther, ArrayList<String> messages){
        ButtonCreator back = new ButtonCreator(50, 650, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setChatPage());
        this.add(back);

        JTextArea chatArea = new JTextArea();
        chatArea.setBounds(500, 100, 500, 500);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        chatArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        chatArea.setEditable(false);

        for (String message : messages)
            chatArea.append(message + "\n");

        JTextField inputField = new JTextField(30);
        inputField.setBounds(500, 600, 500, 30);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                chatArea.append(me + ": " + message + "\n");
                MainFrame.getInstance().sendMessage(me, theOther, message);
                inputField.setText("");
            }
        });

        this.add(inputField);
        this.add(chatArea);
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }

}
