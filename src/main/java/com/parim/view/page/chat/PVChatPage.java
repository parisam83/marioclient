package com.parim.view.page.chat;

import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.swingObjects.ButtonCreator;
import com.parim.view.swingObjects.LabelCreator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PVChatPage extends JPanel {
    private JTextArea chatArea;
    public PVChatPage(String me, String theOther, ArrayList<String> messages){
        LabelCreator label = new LabelCreator("Your chat with " + theOther + ":");
        this.add(label);

        ButtonCreator back = new ButtonCreator(50, 650, "Back");
        back.addActionListener(e -> {
            MainFrame.getInstance().setOnChatWith("");
            MainFrame.getInstance().setChatPage();
        });
        this.add(back);

        chatArea = new JTextArea();
        chatArea.setFont(FontLoader.notificationFont);
        chatArea.setBounds(500, 150, 500, 500);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        chatArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        chatArea.setEditable(false);

        for (String message : messages)
            chatArea.append(message + "\n");

        JTextField inputField = new JTextField(30);
        inputField.setBounds(500, 650, 500, 30);
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
    public void receivedMessage(String message){
        chatArea.append(message);
    }
}
