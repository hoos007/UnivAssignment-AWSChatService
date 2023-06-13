package com.hoos007.project.onlinekaraoke.handler;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    // 접속 시 처리 로직
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 클라이언트의 접속이 성공했을 때 실행되는 로직
        // 클라이언트 정보 변경 등의 작업 수행
        // 예: 사용자 정보, 접속 상태 등 변경
        // session.getId()를 사용하여 클라이언트 세션 식별 가능
    }

    // 끊김 시 처리 로직
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 클라이언트의 접속이 끊겼을 때 실행되는 로직
        // 클라이언트 정보 변경 등의 작업 수행
        // 예: 사용자 정보, 접속 상태 등 변경
        // session.getId()를 사용하여 클라이언트 세션 식별 가능
    }

    // 메시지 처리 로직 (필요한 경우 오버라이드)
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println(payload);
        // 받은 메시지를 원하는 로직에 따라 처리합니다.
        // 필터링, 검증, 가공 등의 작업 수행

    }
}
