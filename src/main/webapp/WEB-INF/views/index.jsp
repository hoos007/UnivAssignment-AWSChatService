<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>onlinekaraoke_main</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/mainPage.js"></script>
        <script type="text/javascript">
            window.onload = function func()
            {
                document.getElementById("btn").onclick=createRoom;
            }
        </script>
    </head>
    <body>
        <h1>online karaoke</h1><br><br>
<%--        <button id="btn">방 만들기</button>--%>
        <form action="${pageContext.request.contextPath}/createRoom" method="post">
            <label for="user_id">User ID:</label>
            <input type="text" id="user_id" name="user_id" required>

            <label for="room_name">Room Name:</label>
            <input type="text" id="room_name" name="room_name" required>

            <button type="submit">방 생성</button>
        </form>
        <button onclick = "location.href = '${pageContext.request.contextPath}/list' ">방 리스트</button>
    </body>
</html>