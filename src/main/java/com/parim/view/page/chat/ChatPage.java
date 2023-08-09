package com.parim.view.page.chat;

import com.parim.view.MainFrame;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;
import java.util.ArrayList;

public class ChatPage extends JPanel {
    public ChatPage(){
        ButtonCreator back = new ButtonCreator(1000, 0, 500, 100, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

        ButtonCreator search = new ButtonCreator(0, 0, 500, 100, "Search");
        search.addActionListener(e -> {
            String ans = JOptionPane.showInputDialog("Search username: ");
            if (ans == null || ans.equals("")) MainFrame.getInstance().setChatPage();
            else MainFrame.getInstance().requestUserMessages(ans);
        });
        this.add(search);

        ButtonCreator block = new ButtonCreator(500, 0, 500, 100,"Block/Unblock");
        block.addActionListener(e -> {
            Object[] choices = {"See list of blocked usernames", "Block/Unblock someone"};
            Object defaultChoice = choices[0];
            int ans = JOptionPane.showOptionDialog(this,
                    "What do you want to do?",
                    "Block/Unblock",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    defaultChoice);
            if (ans == JOptionPane.YES_OPTION){
                MainFrame.getInstance().setListOfBlockedUsernamesPage();
            }
            if (ans == JOptionPane.NO_OPTION) {
                Object[] options = {"Block", "Unblock"};

                JPanel panel = new JPanel();
                panel.add(new JLabel("Enter the username: "));
                JTextField textField = new JTextField(10);
                panel.add(textField);

                int result = JOptionPane.showOptionDialog(null, panel, "Do you want to block or unblock this user?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, null);

                if (result == JOptionPane.YES_OPTION) {
                    MainFrame.getInstance().blockUser(textField.getText());
                }
                if (result == JOptionPane.NO_OPTION) {
                    MainFrame.getInstance().unblockUser(textField.getText());
                }
            }
        });
        this.add(block);

        MainFrame.getInstance().sendChatListRequest();
        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }
    public void loadChatList(ArrayList<String> chatList){
        for (int i = 0; i < chatList.size(); i++){
            ButtonCreator button = new ButtonCreator(1500/2 - 300/2, (i + 1)*100, 300, 100, chatList.get(i));
            final int index = i;
            button.addActionListener(e -> MainFrame.getInstance().requestUserMessages(chatList.get(index)));
            this.add(button);
        }
    }
}
