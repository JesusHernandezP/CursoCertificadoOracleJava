package com.oracle.html5.websocket;

import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class GameWebSocketEncoder implements Encoder.TextStream<Game> {

  @Override
  public void init(EndpointConfig config) {
  }

  @Override
  public void destroy() {
  }

  @Override
  public void encode(Game game, Writer writer) throws EncodeException, IOException {
    JsonArrayBuilder boardObj = Json.createArrayBuilder();
    for (int x = 0; x < 3; x++) {
      JsonArrayBuilder arrObj = Json.createArrayBuilder();
      for (int y = 0; y < 3; y++) {
        arrObj.add(game.getBoard()[x][y].toString());
      }
      boardObj.add(arrObj);
    }
    JsonObject jsonObject = Json.createObjectBuilder()
            .add("board", boardObj)
            .add("message", game.getMessage())
            .add("currentTurn", game.getCurrentTurn().toString())
            .build();
    try (JsonWriter jsonWriter = Json.createWriter(writer)) {
      System.out.println(jsonObject);
      jsonWriter.write(jsonObject);
    }
  }
}
