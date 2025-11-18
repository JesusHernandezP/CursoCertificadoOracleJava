package com.oracle.html5.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(
        value = "/ws/gameWebSocket",
        encoders = {GameWebSocketEncoder.class},
        decoders = {GameWebSocketDecoder.class})
public class GameWebSocket {

  private static Game game = new Game();
  private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
  private static Slot lastPlayer = Slot.CIRCLE;

  @OnOpen
  public void onOpen(Session session) throws IOException, EncodeException {
    sessions.add(session);
    session.getUserProperties().put("player", lastPlayer);
    final String firstMessage = "{\"action\":\"start\", \"player\":\"" + lastPlayer + "\"}";
    System.out.println(firstMessage);
    session.getBasicRemote().sendText(firstMessage);
    session.getBasicRemote().sendObject(game);
    lastPlayer = lastPlayer == Slot.CIRCLE ? Slot.EXXES : Slot.CIRCLE;
  }

  @OnMessage
  public void onMessage(Move move) {
    game.play(move);
    for (Session session : sessions) {
      try {
        session.getBasicRemote().sendObject(game);
      } catch (IOException | EncodeException ex) {
        Logger.getLogger(GameWebSocket.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  @OnClose
  public void onClose(Session session) {
    sessions.remove(session);
  }
}
