package com.parim.event;

public class Message {
    private String title;
    private FormEvent formEvent;

    public Message() {}

    public Message(String title, FormEvent formEvent){
        this.title = title;
        this.formEvent = formEvent;
    }

    public String getTitle() {
        return title;
    }

    public FormEvent getFormEvent() {
        return formEvent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFormEvent(FormEvent formEvent) {
        this.formEvent = formEvent;
    }
}
