package com.parim.event.shop;

import com.parim.event.FormEvent;

public class BuyItemEvent implements FormEvent {
    private String item;
    private boolean hasOptionPain, userChoice, verdict;
    public BuyItemEvent(){}

    public BuyItemEvent(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isHasOptionPain() {
        return hasOptionPain;
    }

    public void setHasOptionPain(boolean hasOptionPain) {
        this.hasOptionPain = hasOptionPain;
    }

    public boolean isUserChoice() {
        return userChoice;
    }

    public void setUserChoice(boolean userChoice) {
        this.userChoice = userChoice;
    }

    public boolean isVerdict() {
        return verdict;
    }

    public void setVerdict(boolean verdict) {
        this.verdict = verdict;
    }
}
