package com.mart.deletebot;

import com.google.gson.Gson;
import sx.blah.discord.handle.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageDeleteEvent;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.MessageUpdateEvent;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.obj.IChannel;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeleteEvent {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Date date = new Date();

    private Config config;

    @EventSubscriber
    public void onEnable(ReadyEvent event){
        System.out.println("Bot is ready and running, time to take them trollers down");
        try {
            config = new Gson().fromJson(new FileReader(new File("config.txt")), Config.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        checkForDirectories();
    }

    @EventSubscriber
    public void onDeleteEvent(MessageDeleteEvent event){
        if(config.isLogDeletes()){
            IChannel channel = event.getMessage().getChannel();
            if(checkForFile(channel.getName(), "logs\\deletes")){
                File channelFile = new File("logs\\deletes\\"+channel.getName()+".txt");
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(channelFile, true)));
                    String message =  "["+dateFormat.format(date) + "]" + event.getMessage().getAuthor().getName() +": "+ event.getMessage().toString();
                    out.println(message);
                    out.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @EventSubscriber
    public void onEditEvent(MessageUpdateEvent event){
        if(config.isLogEdits()) {
            IChannel channel = event.getOldMessage().getChannel();
            String oldMessage = event.getOldMessage().toString();
            String newMessage = event.getNewMessage().toString();
            if (checkForFile(channel.getName(), "logs\\edits")) {
                File channelFile = new File("logs\\edits\\" + channel.getName() + ".txt");
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(channelFile, true)));
                    String message = "[" + dateFormat.format(date) + "]" + event.getOldMessage().getAuthor().getName() + ": " + oldMessage + " {|TO|} " + newMessage;
                    out.println(message);
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @EventSubscriber
    public void onMessageEvent(MessageReceivedEvent event){
        if(config.isLogMessages()) {
            IChannel channel = event.getMessage().getChannel();
            if (checkForFile(channel.getName(), "logs\\messages")) {
                File channelFile = new File("logs\\messages\\" + channel.getName() + ".txt");
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(channelFile, true)));
                    String message = "[" + dateFormat.format(date) + "]" + event.getMessage().getAuthor().getName() + ": " + event.getMessage().toString();
                    out.println(message);
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkForDirectories(){
        File deleteDir = new File("logs\\deletes");
        File editDir = new File("logs\\edits");
        File messageDir = new File("logs\\messages");
        if (!deleteDir.exists()) {
            if (deleteDir.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        if (!editDir.exists()) {
            if (editDir.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
        if (!messageDir.exists()) {
            if (messageDir.mkdirs()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }

    private boolean checkForFile(String channelName, String mainpath){
        File file = new File(mainpath + "\\"+channelName+".txt");

        try {
            if (file.createNewFile()){
                return true;
            }else{
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
