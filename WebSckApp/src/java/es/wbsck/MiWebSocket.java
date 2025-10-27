package es.wbsck;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint")
public class MiWebSocket {

    @OnOpen
    public void abroCon(Session session) {
        System.out.println("> " + session.getId() + " ha abierto una conexión");
        try {
            session.getBasicRemote().sendText("Conexión establecida");
        } catch (IOException ioe) {
            System.out.println("> Error: " + ioe.getMessage());
        }
    }

    @OnMessage
    public String mensaje(String message, Session session) {
        System.out.println("> Mensaje: " + session.getId() + ": " + message);
        return message;
    }

    @OnClose
    public void cierroCon(Session session) {
        System.out.println("> La sesión " + session.getId() + " ha terminado");
    }

}
