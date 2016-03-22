package com.mart.deletebot;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.DiscordException;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.EventDispatcher;

import java.io.*;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    private static String email, password;
    public static IDiscordClient pub;
    public static Connection conn = null;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Email:");
        String email = in.next();
        System.out.println("Password:");
        String password = in.next();
        in.close();
        createConfig();
        IDiscordClient client = null;
        try {
            client = new ClientBuilder().withLogin(email, password).build();
            client.login();
        } catch (DiscordException e) {
            e.printStackTrace();
        }
        pub = client;
        EventDispatcher dispatcher = null;
        if (client != null) {
            dispatcher = client.getDispatcher();
        }
        else{
            System.out.print("This is the error");
        }
        if (dispatcher != null) {
            dispatcher.registerListener(new DeleteEvent());
        }
        else{
            System.out.print("This is DEFO the error");
        }


    }

    private static void createConfig(){
        File file = new File("config.txt");
        try {
            if (file.createNewFile()){
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                String message = "{\"logMessages\":false,\"logDeletes\":true,\"logEdits\":true}";
                out.println(message);
                out.close();
            }else{
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
