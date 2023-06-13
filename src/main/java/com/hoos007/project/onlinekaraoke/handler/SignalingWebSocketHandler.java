package com.hoos007.project.onlinekaraoke.handler;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SignalingWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 시그널링 메시지 처리 로직을 여기에 구현합니다.
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 연결이 수립된 후의 로직을 여기에 구현합니다.
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 연결이 종료된 후의 로직을 여기에 구현합니다.
    }
}
