package com.oracle.html5.demoframework;

import java.util.ArrayList;
import java.util.List;
import javax.json.*;
import javax.servlet.ServletContext;

public class Demo {

  private final String title;
  private final String desc;
  private final String instructions;
  private final List<DemoFile> files = new ArrayList<>();
  private final List<Demo> demos = new ArrayList<>();
  private final String path;
  private final String main;
  private final boolean previewHidden;
  private final boolean runnable;
  private final boolean practice;
  private final FileView fileViewRoot = new FileView("root");

  private Demo(JsonObject jsonDemo, ServletContext context) {
    this.title = jsonDemo.getString("title");
    this.desc = jsonDemo.getString("desc", "");
    this.instructions = jsonDemo.getString("instructions", null);
    this.path = jsonDemo.getString("path", "");
    this.main = path + jsonDemo.getString("main", "");
    this.previewHidden = getBoolean(jsonDemo.get("previewHidden"), false);
    this.practice = getBoolean(jsonDemo.get("practice"), false);
    this.runnable = getBoolean(jsonDemo.get("runnable"), true);
    JsonArray jsonItems = build(jsonDemo.get("items"), context);
    if (jsonItems != null && !jsonItems.isEmpty()) {
      for (JsonValue val : jsonItems) {
        JsonObject jsonItem = (JsonObject) val;
        Demo demo = build(jsonItem, context);
        if (demo != null) {
          demos.add(demo);
        }
      }
    }
    List<String> filePaths = new ArrayList<>();
    JsonArray jsonFiles = jsonDemo.getJsonArray("files");
    if (jsonFiles != null && !jsonFiles.isEmpty()) {
      for (JsonValue val : jsonFiles) {
        JsonObject jsonFile = (JsonObject) val;
        String original = path + jsonFile.getString("original");
        String solution = jsonFile.getString("solution", null);
        String printVer = jsonFile.getString("printVer", null);
        if (solution != null) {
          solution = path + solution;
        }
        if (printVer != null) {
          printVer = path + printVer;
        } else {
          if (solution != null) {
            printVer = solution;
          } else {
            printVer = original;
          }
        }
        boolean hidden = getBoolean(jsonFile.get("hidden"), false);
        boolean readOnly = solution == null;
        if (jsonFile.containsKey("readOnly")) {
          readOnly = getBoolean(jsonFile.get("readOnly"), false);
        }
        files.add(new DemoFile(original, solution, printVer, hidden, readOnly));
        filePaths.add(original);
      }
    }
    buildTree(filePaths);
  }

  private static Boolean getBoolean(JsonValue jsonVal, boolean defValue) {
    if (jsonVal != null) {
      if (jsonVal.getValueType() == JsonValue.ValueType.TRUE) {
        return true;
      }
      if (jsonVal.getValueType() == JsonValue.ValueType.STRING && "true".equalsIgnoreCase(((JsonString) jsonVal).getString())) {
        return true;
      }
      return false;
    } else {
      return defValue;
    }
  }

  private static JsonArray build(JsonValue jsonVal, ServletContext context) {
    if (jsonVal == null) {
      return null;
    }
    if (jsonVal.getValueType() == JsonValue.ValueType.STRING) {
      String path = ((JsonString) jsonVal).getString();
      try (JsonReader reader = Json.createReader(context.getResourceAsStream(path))) {
        return reader.readArray();
      } catch (Exception e) {
        System.err.println("ERROR PARSING PATH: " + path);
        e.printStackTrace();
      }
    }
    if (jsonVal.getValueType() == JsonValue.ValueType.ARRAY) {
      return (JsonArray) jsonVal;

    }
    return null;
  }

  public static Demo build(JsonObject jsonDemo, ServletContext context) {
    String link = jsonDemo.getString("link", null);
    if (link != null) {
      try (JsonReader reader = Json.createReader(context.getResourceAsStream(link))) {
        return new Demo(reader.readObject(), context);
      } catch (Exception e) {
        System.err.println("ERROR PARSING LINK: " + link);
        e.printStackTrace();
      }
      return null;
    } else {
      return new Demo(jsonDemo, context);
    }
  }

  public String getInstructions() {
    return instructions;
  }

  public String getTitle() {
    return title;
  }

  public List<Demo> getDemos() {
    return demos;
  }

  public String getPath() {
    return path;
  }

  public String getMain() {
    return main;
  }

  public List<DemoFile> getFiles() {
    return files;
  }

  public List<DemoFile> getVisibleFiles() {
    List<DemoFile> visible = new ArrayList<>();
    for (DemoFile file : files) {
      if (!file.isHidden()) {
        visible.add(file);
      }
    }
    return visible;
  }

  public String getDesc() {
    return desc;
  }

  public boolean isPreviewHidden() {
    return previewHidden;
  }

  public FileView getFileViewRoot() {
    return fileViewRoot;
  }

  public boolean isRunnable() {
    return runnable;
  }

  private void buildTree(List<String> filePaths) {
    for (String filePath : filePaths) {
      coolAdd(fileViewRoot, 0, filePath.split("/"));
    }
  }

  private static void coolAdd(final FileView node, final int arrIndex, final String[] items) {
    if (arrIndex >= items.length) {
      return;
    }
    String currentItem = items[arrIndex];
    FileView found = null;
    for (FileView child : node.getFiles()) {
      if (child.getName().equals(currentItem)) {
        found = child;
      }
    }
    if (found == null) {
      found = new FileView(currentItem);
      node.getFiles().add(found);
    }
    coolAdd(found, arrIndex + 1, items);
  }

  public boolean isPractice() {
    return practice;
  }

  public boolean isHasPrintableDemos() {
    for (Demo demo : demos) {
      if (!demo.isPractice() && demo.isHasPrintableFiles()) {
        return true;
      }
    }
    return false;
  }

  public boolean isHasPrintableFiles() {
    for (DemoFile file : files) {
      if (file.getPrintedPath() != null) {
        return true;
      }
    }
    return false;
  }

}
