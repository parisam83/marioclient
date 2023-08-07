package com.parim.event;

import java.util.ArrayList;

public class ListOfBlockedUsernamesEvent implements FormEvent {
    private ArrayList<String> blockedUsernames;
    public ListOfBlockedUsernamesEvent(){}

    public ListOfBlockedUsernamesEvent(ArrayList<String> blockedUsernames) {
        this.blockedUsernames = blockedUsernames;
    }

    public ArrayList<String> getBlockedUsernames() {
        return blockedUsernames;
    }

    public void setBlockedUsernames(ArrayList<String> blockedUsernames) {
        this.blockedUsernames = blockedUsernames;
    }
}
