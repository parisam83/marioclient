package com.parim.view.page.notification;

import com.parim.event.notification.NotificationEvent;
import com.parim.model.Notification;
import com.parim.view.MainFrame;
import com.parim.view.loaders.FontLoader;
import com.parim.view.swingObjects.ButtonCreator;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NotificationsPage extends JPanel {
    private final int buttonWidth = 500, buttonHeight = 100;
    private ArrayList<Notification> places = new ArrayList<>();
    private ArrayList<JButton> notifications = new ArrayList<>();
    public NotificationsPage(ArrayList<NotificationEvent> notifications){
        createPlaces();

        if (notifications != null) {
            for (NotificationEvent notificationEvent : notifications)
                createNotification(notificationEvent.getTitle(), notificationEvent.getMessage(), notificationEvent.getType());
        }

        ButtonCreator back = new ButtonCreator(1100, 650, "Back");
        back.addActionListener(e -> MainFrame.getInstance().setMenuPage());
        this.add(back);

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

    private JButton CreateButton(int x, int y, String title, String message, String type) {
        JButton button = new JButton();
        button.setBounds(x, y, buttonWidth, buttonHeight);
        button.setText(MainFrame.getInstance().createText(title, message));
        button.setFont(FontLoader.notificationFont);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (type.equals("Chat")) MainFrame.getInstance().requestUserMessages(title);
//                    if (type.equals("Friend"))
//                    if (type.equals("Game"))
//                    if (type.equals("Room"))
//                    if (type.equals("Item"))
                }
                if (SwingUtilities.isRightMouseButton(e)) removePlace(button);
            }
        });

        return button;
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
        this.remove(button);
        this.repaint();
        this.revalidate();
    }
    private Notification findPlace(JButton button){
        for (Notification place : places)
            if (place.getButton() == button)
                return place;
        return null;
    }
}
