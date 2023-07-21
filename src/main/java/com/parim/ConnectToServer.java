package com.parim;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parim.event.Message;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConnectToServer {
    private ObjectMapper mapper = new ObjectMapper();
    private PrintWriter output;
    private Scanner input;

    public ConnectToServer(Socket socket){
        try {
            output = new PrintWriter(socket.getOutputStream(), true);
            input = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(Message message){
        try {
            output.println(mapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public Message receive(){
        try {
            return mapper.readValue(input.nextLine(), Message.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
