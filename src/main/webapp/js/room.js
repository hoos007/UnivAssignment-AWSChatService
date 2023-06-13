let username;
let roomid;
let stompClient = null;

function connect() {
    username = document.getElementById('userid').value;
    roomid = document.getElementById('roomid').value;
    console.log(username + roomid)
    document.getElementById('name').innerText = username;

    if (username) {
        const socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
        stompClient.disconnect = function() {
            // 서버로 메시지를 전송
            console.log("떠남메시지 시작")
            stompClient.send("/app/chat.sendMessage/" + roomid, {}, JSON.stringify({
                room: roomid,
                sender: username,
                content: username + "님이 나가셨습니다.",
                type: 'LEAVE'
            }));
            console.log("떠남메시지 끝")
        };
    }
}

function onConnected() {
    stompClient.subscribe('/topic/rooms/'+roomid, onMessageReceived);
    console.log("입장메시지 시작")

    stompClient.send("/app/chat.sendMessage/" + roomid, {}, JSON.stringify({
        room: roomid,
        sender: username,
        content: username + "님이 입장하셨습니다.",
        type: 'JOIN'
    }));
    console.log("입장메시지 끝")
}

function sendMessage() {
    const messageContent = document.getElementById('sendContent').value.trim();
    console.log('messageContent:', messageContent);

    document.getElementById('chatContent').value += "\n나("+username+") : "+messageContent;
    if(messageContent && stompClient) {
        const chatMessage = {
            room: roomid,
            sender: username,
            content: document.getElementById('sendContent').value,
            type: 'CHAT'
        };
        console.log('Sending chatMessage:', chatMessage);
        stompClient.send("/app/chat.sendMessage/"+roomid, {}, JSON.stringify(chatMessage));
        document.getElementById('sendContent').value = '';
    }
}

// 웹소켓 연결이 끊겼을 때 처리
// stompClient.disconnect = function() {
//     // 서버로 메시지를 전송
//     console.log("떠남메시지 시작")
//     stompClient.send("/app/chat.sendMessage/" + roomid, {}, JSON.stringify({
//         room: roomid,
//         sender: username,
//         content: username + "님이 나가셨습니다.",
//         type: 'LEAVE'
//     }));
//     console.log("떠남메시지 끝")
// };


function onError(event) {
}

function onMessageReceived(payload) {
    const message = JSON.parse(payload.body);

    if (message.type === 'JOIN') {
        document.getElementById('chatContent').value += "\n" + message.sender + " : " + message.content;
    } else if (message.type === 'LEAVE') {
        document.getElementById('chatContent').value += "\n" + message.sender + " : " + message.content;
    } else if (message.type === 'CHAT') {
        if (message.sender !== username)
        {
            document.getElementById('chatContent').value += "\n" + message.sender + " : " + message.content;
        }
    }
}

export { connect, sendMessage };