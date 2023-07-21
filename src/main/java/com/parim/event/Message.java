package com.parim.event;

public class Message {
    private String message;
    private FormEvent formEvent;

    public Message() {}

    public Message(String message, FormEvent formEvent){
        this.message = message;
        this.formEvent = formEvent;
    }

    public String getMessage() {
        return message;
    }

    public FormEvent getFormEvent() {
        return formEvent;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFormEvent(FormEvent formEvent) {
        this.formEvent = formEvent;
    }
}
