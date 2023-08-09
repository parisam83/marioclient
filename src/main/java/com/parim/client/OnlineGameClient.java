package com.parim.client;

import com.parim.Client;
import com.parim.ConnectToServer;
import com.parim.access.UserAccess;
import com.parim.event.chat.chatList.ChatListEvent;
import com.parim.event.chat.block.ListOfBlockedUsernamesEvent;
import com.parim.event.chat.message.MessageEvent;
import com.parim.event.chat.message.SendMessageEvent;
import com.parim.event.chat.block.BlockUserEvent;
import com.parim.event.chat.block.UnblockUserEvent;
import com.parim.event.notification.NotificationEvent;
import com.parim.event.notification.UserNotifications;
import com.parim.event.room.RoomEvent;
import com.parim.event.shop.BuyItemEvent;
import com.parim.event.shop.ItemEvent;
import com.parim.event.user.UserEvent;
import com.parim.model.Chat;
import com.parim.model.Message;
import com.parim.model.Room;
import com.parim.model.User;
import com.parim.view.MainFrame;

import java.net.Socket;

public class OnlineGameClient {
    private static OnlineGameClient instance;
    private Socket socket;
    private ConnectToServer connectToServer;
    public OnlineGameClient(Socket socket){
        instance = this;

        this.socket = socket;
        connectToServer = new ConnectToServer(socket);
        runOnlineGame();
    }

    private void runOnlineGame() {
        while (!socket.isClosed()){
            Message serverRespond =connectToServer.receive();
            String title = serverRespond.getTitle();
            if (title.equals("UserRegisterSuccessful")) receivedUserRegisterSuccessful();
            if (title.equals("UserRegisterUnsuccessful")) receivedUserRegisterUnsuccessful();
            if (title.equals("UserLoginSuccessful")) receivedUserLoginSuccessful();
            if (title.equals("UserLoginUnsuccessful")) receivedUserLoginUnsuccessful();
            if (title.equals("ItemEvent")) receivedItemEvent((ItemEvent) serverRespond.getFormEvent());
            if (title.equals("ComboItemEvent")) receivedComboItemEvent((ItemEvent) serverRespond.getFormEvent());
            if (title.equals("BuyItemEvent")) receivedBuyItemEvent((BuyItemEvent) serverRespond.getFormEvent());
            if (title.equals("ChatListEvent")) receivedChatListEvent((ChatListEvent) serverRespond.getFormEvent());
            if (title.equals("MessageEvent")) receivedMessageEvent((MessageEvent) serverRespond.getFormEvent());
            if (title.equals("ListOfBlockedUsernamesEvent")) receivedListOfBlockedUsernamesEvent((ListOfBlockedUsernamesEvent) serverRespond.getFormEvent());
            if (title.equals("RoomEvent")) receivedRoomEvent((RoomEvent) serverRespond.getFormEvent());
            if (title.equals("RemoveFromRoom")) receivedRemoveFromRoom((RoomEvent) serverRespond.getFormEvent());
            if (title.equals("NotificationEvent")) receivedNotificationEvent((NotificationEvent) serverRespond.getFormEvent());
            if (title.equals("UserNotifications")) receivedUserNotifications((UserNotifications) serverRespond.getFormEvent());
            if (title.equals("RunRoomGame")) receivedRunRoomGame((RoomEvent) serverRespond.getFormEvent());
            if (title.equals("StartRoomGame")) startRoomGame((RoomEvent) serverRespond.getFormEvent());
        }
        connectToServer.send(new Message("ClientClosedEvent", null)); // notifies server that client disconnected
    }

    private void startRoomGame(RoomEvent roomEvent) {
        MainFrame.getInstance().startRoomGame(roomEvent);
    }

    private void receivedRunRoomGame(RoomEvent roomEvent) {
        MainFrame.getInstance().showRunRoomGame(roomEvent);
    }

    private void receivedUserNotifications(UserNotifications userNotifications) {
        MainFrame.getInstance().setNotificationsPage(userNotifications);
    }

    private void receivedNotificationEvent(NotificationEvent notificationEvent) {
        System.out.println("receivedNotificationEvent");
        System.out.println(notificationEvent.getTitle());
        System.out.println(notificationEvent.getMessage());
        System.out.println(notificationEvent.getType() + "\n");
        MainFrame.getInstance().showNotification(notificationEvent);
    }

    private void receivedRemoveFromRoom(RoomEvent roomEvent) {
        MainFrame.getInstance().showRemoveFromRoom(roomEvent);
    }

    public void receivedRoomEvent(RoomEvent roomEvent){
        MainFrame.getInstance().receivedRoomEvent(roomEvent);
    }
    public void sendRegisterMessage(User user) {
        UserAccess.getInstance().add(user);
        connectToServer.send(new Message("UserRegisterEvent", new UserEvent(user)));
    }
    public void sendLoginMessage(User user) {
        connectToServer.send(new Message("UserLoginEvent", new UserEvent(user)));
    }
    public void sendGetItemsMessage(){
        connectToServer.send(new Message("ItemEvent", null));
    }
    public void sendBuyItemMessage(String itemName) {
        connectToServer.send(new Message("BuyItemEvent", new BuyItemEvent(itemName)));
    }
    public void sendChatListRequest(){
        connectToServer.send(new Message("ChatListRequest", null));
    }
    public void requestUserMessages(String username){
        connectToServer.send(new Message("MessageEvent", new MessageEvent(new Chat(username, ""))));
    }
    public void sendMessage(String sender, String receiver, String message){
        connectToServer.send(new Message("SendMessageEvent", new SendMessageEvent(sender, receiver, message)));
    }
    public void requestListOfBlockedUsernames(){
        connectToServer.send(new Message("ListOfBlockedUsernamesEvent", null));
    }
    public void sendBlockUserEvent(String username){
        connectToServer.send(new Message("BlockUserEvent", new BlockUserEvent(username)));
    }
    public void sendUnblockUserEvent(String username){
        connectToServer.send(new Message("UnblockUserEvent", new UnblockUserEvent(username)));
    }
    public void createNewRoom(String password){
        connectToServer.send(new Message("NewRoomEvent", new RoomEvent(new Room(password))));
    }
    public void joinRoom(String id, String password){
        connectToServer.send(new Message("JoinRoomEvent", new RoomEvent(new Room(id, password))));
    }

    private void receivedUserRegisterSuccessful(){
        Client.getInstance().receivedRegisterResult("yes");
    }
    private void receivedUserRegisterUnsuccessful() {
        Client.getInstance().receivedRegisterResult("no");
    }
    private void receivedUserLoginSuccessful(){
        Client.getInstance().receivedLoginResult("yes");
    }
    private void receivedUserLoginUnsuccessful() {
        Client.getInstance().receivedLoginResult("no");
    }
    private void receivedItemEvent(ItemEvent itemEvent){
        Client.getInstance().receivedItemEvent(itemEvent);
    }
    private void receivedComboItemEvent(ItemEvent itemEvent){
        Client.getInstance().receivedComboItemEvent(itemEvent);
    }
    private void receivedBuyItemEvent(BuyItemEvent buyItemEvent){
        // TODO
    }
    private void receivedChatListEvent(ChatListEvent chatListEvent){
        Client.getInstance().receivedChatListEvent(chatListEvent);
    }
    private void receivedMessageEvent(MessageEvent messageEvent){
        MainFrame.getInstance().receivedMessageEvent(messageEvent.getChat());
    }
    private void receivedListOfBlockedUsernamesEvent(ListOfBlockedUsernamesEvent listOfBlockedUsernamesEvent){
        MainFrame.getInstance().showBlockedUsernames(listOfBlockedUsernamesEvent.getBlockedUsernames());
    }
    public static OnlineGameClient getInstance() {
        return instance;
    }

    public void sendInviteLink(String username, Room room) {
        RoomEvent roomEvent = new RoomEvent(room, username);
        connectToServer.send(new Message("InviteToRoom", roomEvent));
    }

    public void removeUserFromRoom(String userToRemove, Room room) {
        RoomEvent roomEvent = new RoomEvent(room, userToRemove);
        connectToServer.send(new Message("RemoveFromRoom", roomEvent));
    }

    public void requestUserNotifications() {
        connectToServer.send(new Message("UserNotifications", null));
    }

    public void setNewAssistant(String newAssistant, Room room) {
        RoomEvent roomEvent = new RoomEvent(room, newAssistant);
        connectToServer.send(new Message("AddNewAssistant", roomEvent));
    }

    public void runRoomGame(Room room) {
        connectToServer.send(new Message("RunRoomGame", new RoomEvent(room)));
    }

    public void sendVerdictRunRoom(RoomEvent roomEvent) {
        connectToServer.send(new Message("VerdictRunRoom", roomEvent));
    }
}
