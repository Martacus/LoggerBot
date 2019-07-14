package com.mart.deletebot;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.DiscordException;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.EventDispatcher;

import java.io.*;
import java.sql.Connection;
import java.util.Scanner;

public class Main {

    private static String token;
    public static IDiscordClient pub;
    public static Connection conn = null;

    public static void main(String[] args){

        token = args[0];
        createConfig();
        IDiscordClient client = null;
        try {
            client = new ClientBuilder(token).build();
            client.login().block();
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
            dispatcher.registerListener(new MessageEvent());
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
                String message = "{\"logMessages\":false,\"logDeletes\":true,\"logEdits\":true,\"addRoleToLog\":false}";
                out.println(message);
                out.close();
            }else{
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
