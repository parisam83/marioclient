package com.parim.event.room;

import com.parim.event.FormEvent;
import com.parim.model.Room;

public class RoomEvent implements FormEvent {
    private Room room;
    private String someUser;
    public RoomEvent(){}

    public RoomEvent(Room room) {
        this.room = room;
    }

    public RoomEvent(Room room, String someUser) {
        this.room = room;
        this.someUser = someUser;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getSomeUser() {
        return someUser;
    }

    public void setSomeUser(String someUser) {
        this.someUser = someUser;
    }
}
