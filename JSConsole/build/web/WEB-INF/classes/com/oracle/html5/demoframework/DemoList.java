package com.oracle.html5.demoframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.servlet.ServletContext;

@ApplicationScoped
@Named("demoList")
public class DemoList {

  @Inject
  private FileManager fileManager;
  @Inject
  private ServletContext context;
  private final List<Demo> demos = new ArrayList<>();
  private final Map<String, DemoFile> demoFiles = new HashMap<>();
  private final Map<String, Demo> demoMap = new HashMap<>();

  @PostConstruct
  public void init() {
    demos.clear();
    demoFiles.clear();
    demoMap.clear();
    try (JsonReader reader = Json.createReader(context.getResourceAsStream("/desc.info.json"))) {
      JsonArray array = reader.readArray();
      for (JsonValue val : array) {
        JsonObject jsonObject = (JsonObject) val;
        Demo demo = Demo.build(jsonObject, context);
        if (demo != null) {
          demos.add(demo);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    new DemoIterator(demos) {
      @Override
      public void each(Demo demo) {
        demoMap.put(demo.getPath(), demo);
        for (DemoFile demoFile : demo.getFiles()) {
          demoFiles.put(demoFile.getOriginalPath(), demoFile);
          //fileManager.init(demoFile);
        }
      }
    }.iterate();
  }

  public Demo getDemo(String name) {
    return demoMap.get(name);
  }

  public List<Demo> getDemos() {
    return demos;
  }

  public DemoFile getFile(String requestedFile) {
    return demoFiles.get(requestedFile);
  }
}
