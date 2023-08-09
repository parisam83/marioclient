package com.parim.view;

import com.parim.Client;
import com.parim.client.OnlineGameClient;
import com.parim.event.ChatListEvent;
import com.parim.event.ItemEvent;
import com.parim.event.notification.NotificationEvent;
import com.parim.event.notification.UserNotifications;
import com.parim.event.room.RoomEvent;
import com.parim.model.Chat;
import com.parim.model.Room;
import com.parim.model.User;
import com.parim.view.page.*;
import com.parim.view.page.game.GamePage;
import com.parim.view.page.game.TimeToStartGamePage;
import com.parim.view.page.room.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private static MainFrame instance;
    private static final int WIDTH = 1500, HEIGHT = 800;
    private static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    private ShopPage shopPage;
    private ChatPage chatPage;
    private ListOfBlockedUsernamesPage listOfBlockedUsernamesPage;
    private String onChatWith;
    private RoomsPage roomsPage;
    private String username;
    private NotificationsPage notificationPage;
    public MainFrame(){
        if (instance != null) return;
        instance = this;

        this.setTitle("+++++");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(DIMENSION);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - WIDTH/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - HEIGHT/2);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void setConnectingPage() {
        setPage(new ConnectingPage());
    }
    public void setFailedConnectionPage(){
        setPage(new FailedConnectionPage());
    }
    public void setAccountPage(){
        setPage(new AccountPage());
    }
    private void setRegisterPage(){
        setPage(new RegisterPage());
    }
    private void setLoginPage(){
        setPage(new LoginPage());
    }
    public void setMenuPage() {
        setPage(new MenuPage());
    }
    public void setNotificationsPage(UserNotifications userNotifications){
        setPage(notificationPage = new NotificationsPage(userNotifications.getNotifications()));
    }
    public void setRoomsPage(){
        setPage(roomsPage = new RoomsPage());
    }
    public void setScoreboardPage(){
        setPage(new ScoreboardPage());
    }
    public void setOnlineScoreboardPage(){
        // TODO
    }
    public void setOfflineScoreboardPage(){
        // TODO
    }
    public void setShopPage(){
        setPage(shopPage = new ShopPage());
    }
    public void setChatPage(){
        setPage(chatPage = new ChatPage());
    }
    public void setPVChatPage(String me, String theOther, ArrayList<String> messages){
        setPage(new PVChatPage(me, theOther, messages));
    }
    public void setListOfBlockedUsernamesPage(){
        OnlineGameClient.getInstance().requestListOfBlockedUsernames();
        setPage(listOfBlockedUsernamesPage = new ListOfBlockedUsernamesPage());
    }
    public void setManagerRoomPage(RoomEvent roomEvent){
        setPage(new ManagerRoomPage(roomEvent.getRoom()));
    }
    public void setNormalUserRoomEvent(RoomEvent roomEvent){
        setPage(new NormalUserRoomEvent(roomEvent.getRoom()));
    }
    public void setAssistantRoomPage(RoomEvent roomEvent){
        setPage(new AssistantRoomPage(roomEvent.getRoom()));
    }
    public void setTimeToStartGamePage(int time){
        setPage(new TimeToStartGamePage(time));
    }
    public void setGamePage(){
        setPage(new GamePage());
    }

    private void setPage(JPanel panel) {
        panel.setVisible(true);
        panel.repaint();
        panel.revalidate();
        this.setContentPane(panel);
        this.repaint();
        this.revalidate();
        this.pack();
    }
    public void createNewRoom(String password){
        OnlineGameClient.getInstance().createNewRoom(password);
    }
    public void joinRoom(String id, String password){
        OnlineGameClient.getInstance().joinRoom(id, password);
    }
    public void showBlockedUsernames(ArrayList<String> blockedUsernames){
        listOfBlockedUsernamesPage.showBlockedUsernames(blockedUsernames);
        listOfBlockedUsernamesPage.repaint();
        listOfBlockedUsernamesPage.revalidate();
    }

    // Getters and Setters

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static Dimension getDIMENSION() {
        return DIMENSION;
    }

    public static MainFrame getInstance() {
        return instance;
    }

    public void setOnChatWith(String onChatWith) {
        this.onChatWith = onChatWith;
    }

    public void clickedOnTryAgain() {
        Client.getInstance().clickedOnTryConnectingToServer();
    }
    public void clickedOnOfflineGame(){
        Client.getInstance().clickedOnOfflineGame();
    }

    public void clickedOnRegister() {
        setRegisterPage();
    }
    public void clickedOnLogin(){
        setLoginPage();
    }
    public void requestUserMessages(String username){
        onChatWith = username;
        System.out.println(onChatWith);
        OnlineGameClient.getInstance().requestUserMessages(username);
    }
    public void requestUserNotifications(){
        OnlineGameClient.getInstance().requestUserNotifications();
    }
    public void blockUser(String username){
        OnlineGameClient.getInstance().sendBlockUserEvent(username);
    }
    public void unblockUser(String username){
        OnlineGameClient.getInstance().sendUnblockUserEvent(username);
    }
    public void sendChatListRequest(){
        Client.getInstance().sendChatListRequest();
    }

    // Errors for login
    public void emptyValueInputError(){
        JOptionPane.showMessageDialog(this, "You cannot set your username or password empty!", "EmptyValueInputError", JOptionPane.ERROR_MESSAGE);
    }
    public void defaultValueInputError(){
        JOptionPane.showMessageDialog(this, "You cannot set your username and password as their default value!", "DefaultValueInputError", JOptionPane.ERROR_MESSAGE);
    }
    public void unsuccessfulLoginError(){
        JOptionPane.showMessageDialog(this, "Username or password is not correct!", "UnsuccessfulLoginError", JOptionPane.ERROR_MESSAGE);
    }
    public void unsuccessfulRegisterError(){
        JOptionPane.showMessageDialog(this, "This username is taken. Please try another username.", "UnsuccessfulRegisterError", JOptionPane.ERROR_MESSAGE);
    }

    public void sendRegisterMessage(User user) {
        username = user.getUsername();
        Client.getInstance().sendRegisterMessage(user);
    }
    public void sendLoginMessage(User user) {
        username = user.getUsername();
        Client.getInstance().sendLoginMessage(user);
    }
    public void getItems(){
        Client.getInstance().sendGetItemsMessage();
    }
    public void sendBuyItemMessage(String itemName){
        Client.getInstance().sendBuyItemMessage(itemName);
    }

    public void receivedRegisterResult(String result) {
        if (result.equals("no")) {
            username = null;
            unsuccessfulRegisterError();
        }
        else setMenuPage();
    }
    public void receivedLoginResult(String result) {
        if (result.equals("no")) {
            username = null;
            unsuccessfulLoginError();
        }
        else setMenuPage();
    }
    public void receivedItemEvent(ItemEvent itemEvent){
        shopPage.loadShop(itemEvent);
        shopPage.repaint();
        shopPage.revalidate();
    }
    public void receivedComboItemEvent(ItemEvent itemEvent){
        shopPage.loadCombo(itemEvent);
        shopPage.repaint();
        shopPage.revalidate();
    }
    public void receivedChatListEvent(ChatListEvent chatListEvent){
        System.out.println("receivedChatListEvent");
        System.out.println(chatListEvent.getChatList());
        chatPage.loadChatList(chatListEvent.getChatList());
        chatPage.repaint();
        chatPage.revalidate();
    }
    public void receivedMessageEvent(Chat chat){
        System.out.println(chat.getUsername1() + ", " + chat.getUsername2());
        System.out.println("onchatwith " + onChatWith);

        if (onChatWith == null) return;
        if (onChatWith.equals(chat.getUsername1()))
            setPVChatPage(chat.getUsername2(), chat.getUsername1(), chat.getMessages());
        else if (onChatWith.equals(chat.getUsername2()))
            setPVChatPage(chat.getUsername1(), chat.getUsername2(), chat.getMessages());
    }

    private String trimMessage(String message) {
        return message.substring(0, 40);
    }

    public void receivedRoomEvent(RoomEvent roomEvent){
        if (roomEvent.getRoom() == null)
            showFailedJoinRoom();
        else if (roomEvent.getRoom().getBoss().equals(username))
            setManagerRoomPage(roomEvent);
        else if (roomEvent.getRoom().getAssistants().contains(username))
            setAssistantRoomPage(roomEvent);
        else
            setNormalUserRoomEvent(roomEvent);
    }
    public void sendMessage(String sender, String receiver, String message){
        Client.getInstance().sendMessage(sender, receiver, message);
    }

    public static boolean isOfflineGame(){
        return Client.getInstance().isOfflineGame();
    }
    public String createText(String title, String message){
        String joinedText = title + "\n" + message;
        return "<html>" + joinedText.replaceAll("\\n", "<br>") + "</html>";
    }
    public String createText(String text){
        return "<html>" + text.replaceAll("\\n", "<br>") + "</html>";
    }

    public void showFailedJoinRoom() {
        JOptionPane.showMessageDialog(this, "The id or password of room is incorrect.", "Unsuccessful Join Room Error", JOptionPane.ERROR_MESSAGE);
    }
    public void showFailedRemoveFromRoom(){
        JOptionPane.showMessageDialog(this, "You can't remove manager or other assistants!", "Unsuccessful Remove From Room Error", JOptionPane.ERROR_MESSAGE);
    }

    public void removeUserFromRoom(String userToRemove, Room room) {
        if (room.getBoss().equals(username))
            OnlineGameClient.getInstance().removeUserFromRoom(userToRemove, room);
        else if (room.getAssistants().contains(username)){
            if (room.getBoss().equals(userToRemove) || room.getAssistants().contains(userToRemove))
                showFailedRemoveFromRoom();
            else
                OnlineGameClient.getInstance().removeUserFromRoom(userToRemove, room);
        }
    }

    public void showRemoveFromRoom(RoomEvent roomEvent) {
        if (this.getContentPane().getName().equals("AssistantRoomPage") ||
            this.getContentPane().getName().equals("NormalUserRoomEvent"))
            setMenuPage();
    }

    public void showNotification(NotificationEvent notificationEvent){
        if (notificationPage != null) notificationPage.createNotification(notificationEvent.getTitle(), notificationEvent.getMessage(), notificationEvent.getType());
    }

    public void showRunRoomGame(RoomEvent roomEvent) {
        int ans = JOptionPane.showConfirmDialog(this,"Do you want to start game in room " + roomEvent.getRoom().getId() + "?");
        if (ans == JOptionPane.YES_OPTION) roomEvent.setSomeUser("yes");
        else roomEvent.setSomeUser("no");
        OnlineGameClient.getInstance().sendVerdictRunRoom(roomEvent);
    }

    public void startRoomGame(RoomEvent roomEvent) {
        Timer timer = new Timer(1000, new ActionListener() {
            private int counter = 30;

            @Override
            public void actionPerformed(ActionEvent e) {
                setTimeToStartGamePage(counter);
                counter--;
                if (counter == 0) {
                    ((Timer)e.getSource()).stop();
                    setGamePage();
                }
            }
        });
        timer.start();
    }
}
