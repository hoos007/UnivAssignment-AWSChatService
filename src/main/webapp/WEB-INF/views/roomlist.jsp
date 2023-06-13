<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="software.amazon.awssdk.services.dynamodb.model.AttributeValue" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방 리스트</title>
    <style>
        table {
            width: 100%;
        }
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
    </style>
    <script>
        function promptAndRedirect(roomId, roomName) {
            var userName = prompt("이름을 입력해주세요.");
            if (userName) {
                window.location.href = "${pageContext.request.contextPath}/room?room_id=" + roomId + "&user_id=" + userName;
            }
        }
    </script>
</head>
<body>
<h1>방 리스트</h1>
<table>
    <thead>
    <tr>
        <th>방 번호(room_id)</th>
        <th>방 이름(room_name)</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Map<String, AttributeValue>> rooms = (List<Map<String, AttributeValue>>)request.getAttribute("list");
        for (Map<String, AttributeValue> room : rooms) { %>
    <tr>
        <td><%= room.get("room_id").s() %></td>
        <td><a href="#" onclick="promptAndRedirect('<%= room.get("room_id").s() %>','<%= room.get("room_name").s() %>')"><%= room.get("room_name").s() %></a></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
