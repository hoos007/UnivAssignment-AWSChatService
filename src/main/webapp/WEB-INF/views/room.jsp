<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <input type="hidden" id="userid" value="${userid}"/>
    <input type="hidden" id="roomid" value="${roomid}"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
    <script type="module">
        import { connect, sendMessage } from "${pageContext.request.contextPath}/js/room.js";

        const btn = document.getElementById("send-button");
        btn.addEventListener("click", sendMessage);

        window.addEventListener("load", () => {
            connect();
        });
        const inviteLink = document.getElementById("inviteLink");
        const currentUrl = window.location.protocol + "//" + window.location.host + "/room/" + document.getElementById("roomid").value;
        inviteLink.innerText = currentUrl;
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/room.css">
    <title>room</title>
</head>
<body>
<div class="wrapper">
    <!-- 노래방 화면 -->
    <div class="karaoke-container">
        <div id="streamingVideo"></div>
        <div class="invite-link-container">
            <p>초대 링크: <span id="inviteLink"></span></p>
        </div>
    </div>
    <div class="chat-wrapper">
        <div class="chat-container">
            <h3 id="name"></h3>
            <textarea id="chatContent" cols="30" rows="40" readonly></textarea>
            <input type="text" id="sendContent" size="20" />
            <button type="button" id="send-button">전송하기</button>
        </div>
    </div>
</div>

</body>
</html>