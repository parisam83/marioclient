package com.parim.view.page;

import com.parim.model.Notification;
import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NotificationsPage extends JPanel {
    private static NotificationsPage instance;
    private final int buttonWidth = 500, buttonHeight = 100;
    private ArrayList<Notification> places = new ArrayList<>();
    private ArrayList<JButton> notifications = new ArrayList<>();
    public NotificationsPage(){
        if (instance != null) return;
        instance = this;
        createPlaces();

        for (int i = 0 ; i < places.size(); i++) {
            createNotification("Mohammad Brk " + i, "Hi. This is a 40 character sentence for.", "Chat");
        }

        this.setLayout(null);
        this.setPreferredSize(MainFrame.getDIMENSION());
    }

    public void createNotification(String title, String message, String type){
        Notification place = getEmptyPlace();
        if (place == null){
            System.out.println("Bug! :: No place for new notification!");
            return;
        }
        JButton button = CreateButton(place.getX(), place.getY(), title, message, type);
        place.setButton(button);
        notifications.add(button);
        this.add(button);
    }

    public JButton CreateButton(int x, int y, String title, String message, String type) {
        JButton button = new JButton();
        button.setBounds(x, y, buttonWidth, buttonHeight);
        button.setText(createText(title, message));
        button.setFont(FontLoader.notificationFont);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // TODO
                    if (type.equals("Chat")) System.out.println("going to " + title + "'s chat...");
//                    if (type.equals("Friend"))
//                    if (type.equals("Game"))
//                    if (type.equals("Item"))
                }
                if (SwingUtilities.isRightMouseButton(e)) removePlace(button);
            }
        });

        return button;
    }

    private String createText(String title, String message){
        String joinedText = title + "\n" + message;
        return "<html>" + joinedText.replaceAll("\\n", "<br>") + "</html>";
    }

    private void createPlaces(){
        for (int i = 0; i <= MainFrame.getWIDTH() - buttonWidth; i += buttonWidth)
            for (int j = 0; j <= MainFrame.getHEIGHT() - buttonHeight; j += buttonHeight)
                places.add(new Notification(i, j));
    }

    private Notification getEmptyPlace(){
        for (Notification place : places)
            if (place.isEmpty()){
                return place;
            }
        return null;
    }
    private void removePlace(JButton button){
        findPlace(button).setButton(null);
        instance.remove(button);
        instance.repaint();
        instance.revalidate();
    }
    private Notification findPlace(JButton button){
        for (Notification place : places)
            if (place.getButton() == button)
                return place;
        return null;
    }
}
