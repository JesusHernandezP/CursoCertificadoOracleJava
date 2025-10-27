var wsUri = "ws://" + document.location.host + document.location.pathname + "endpoint";
var websocket;
var output = document.getElementById("output");
function openSocket() {
 // Asegura que sólo una conexión se abre a la vez
 if (websocket !== undefined && websocket.readyState !== websocket.CLOSED) {
 writeResponse("El WebSocket ya está abierto");
 return;
 }
 websocket = new WebSocket(wsUri); // Abro el socket con la uri de wsUri del principio
 websocket.onOpen = function (event) {
 if (event.data === undefined) {
 return;
 }
 writeResponse(event.data);
 };
}
function send() {
 var text = document.getElementById("mensajeEntrada").value;
 websocket.send(text); // Mensaje al servidor
 writeResponse(text); // Mensaje en cliente (como eco de comprobación)
}
function closeSocket() {
 websocket.send("cerrando");
 websocket.close();
 writeResponse("Fin de transmisión");
}
function writeResponse(text) {
 output = document.getElementById("output");
 output.innerHTML += text + "<br>";
 }
 