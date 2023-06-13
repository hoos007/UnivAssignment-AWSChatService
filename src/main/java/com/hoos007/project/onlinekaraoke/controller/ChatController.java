package com.hoos007.project.onlinekaraoke.controller;

import com.hoos007.project.onlinekaraoke.DO.ChatMessageDO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
@Service
public class ChatController {
    @MessageMapping("/chat.sendMessage/{roomId}")
    @SendTo("/topic/rooms/{roomId}")
    public ChatMessageDO sendMessage(@Payload ChatMessageDO chatMessage) {
        System.out.println("Received message: " + chatMessage.getContent());
        return chatMessage;
    }

//    @MessageMapping("/chat.addUser/{roomId}")
//    @SendTo("/topic/rooms/{roomId}")
//    public ChatMessageDO addUser(@Payload ChatMessageDO chatMessage, SimpMessageHeaderAccessor headerAccessor) {
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }
}
