
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatWebSocket")
public class ChatWebSocket {

  private static final Set<Session> sessions = new HashSet<>();
  private static final LinkedList<String> messages = new LinkedList<>();
  private static int id = 1;

  @OnOpen
  public void onOpen(Session session) throws IOException {
    sessions.add(session);
    session.getUserProperties().put("id", id++);
    for (String message : messages) {
      session.getBasicRemote().sendText(message);
    }
  }

  @OnMessage
  public void onMessage(Session session, String message) {
    message = "user " + session.getUserProperties().get("id") + " says:\"" + message + "\"";
    messages.push(message);
    if (messages.size() > 15) {
      messages.pop();
    }
    for (Iterator<Session> iter = sessions.iterator(); iter.hasNext();) {
      Session recipient = iter.next();
      try {
        recipient.getBasicRemote().sendText(message);
      } catch (Exception e) {
        iter.remove();
      }
    }
  }

  @OnClose
  public void onClose(Session session) {
    sessions.remove(session);
  }
}
