var socket = new WebSocket("ws://localhost:8080/JSConsole/chatWebSocket");
socket.onmessage = function(event) {
  var chatMessage = event.data;
  var messageElement = document.getElementById("messages");
  messageElement.innerHTML = "<b>" + chatMessage + "<br>" + messageElement.innerHTML;
};

function sendMessage() {
  var messageField = document.getElementById("message");
  socket.send(messageField.value);
  messageField.value = "";
}
