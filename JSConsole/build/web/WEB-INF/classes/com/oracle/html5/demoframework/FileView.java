package com.oracle.html5.demoframework;

import java.util.ArrayList;
import java.util.List;

public class FileView {

  private final String name;
  private final List<FileView> files = new ArrayList<>();

  public FileView(String name) {
    this.name = name;
  }

  public boolean isDirectory() {
    return !files.isEmpty();
  }

  public String getName() {
    return name;
  }

  public List<FileView> getFiles() {
    return files;
  }

}
