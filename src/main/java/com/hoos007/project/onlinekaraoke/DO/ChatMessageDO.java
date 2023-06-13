package com.hoos007.project.onlinekaraoke.DO;

import org.springframework.stereotype.Repository;

@Repository
public class ChatMessageDO {
    public enum MessageType {
        JOIN, LEAVE, CHAT
    }

    private String room;
    private MessageType type;
    private String content;
    private String sender;

    public ChatMessageDO() {

    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
