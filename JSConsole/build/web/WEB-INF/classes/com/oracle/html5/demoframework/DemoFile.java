package com.oracle.html5.demoframework;

public class DemoFile {

  private final String originalPath;
  private final String solutionPath;
  private final String name;
  private final boolean hidden;
  private final boolean readOnly;
  private final boolean binary;
  private final String printedPath;
  private final String contentType;

  public DemoFile(String originalPath, String solutionPath, String printedPath, boolean hidden, boolean readOnly) {
    this.originalPath = "/" + originalPath;
    this.solutionPath = solutionPath == null ? null : "/" + solutionPath;
    int lastSlash = originalPath.lastIndexOf('/');
    this.name = originalPath.substring(lastSlash);
    this.hidden = hidden;
    this.readOnly = readOnly;
    this.printedPath = printedPath.length() > 0 ? "/" + printedPath : null;
    this.contentType = getContentType(name);
    this.binary = isBinary(name);
  }

  public String getOriginalPath() {
    return originalPath;
  }

  public String getSolutionPath() {
    return solutionPath;
  }

  public String getName() {
    return name;
  }

  public boolean isHidden() {
    return hidden;
  }

  public boolean isReadOnly() {
    return readOnly;
  }

  public boolean isBinary() {
    return binary;
  }

  public String getContentType() {
    return contentType;
  }

  public static String getContentType(final String file) {
    if (file.endsWith("js")) {
      return "application/javascript;charset=UTF-8";
    } else if (file.endsWith("css")) {
      return "text/css;charset=UTF-8";
    } else if (file.endsWith("html")) {
      return "text/html;charset=UTF-8";
    } else if (file.endsWith("jpg")) {
      return "image/jpeg";
    } else if (file.endsWith("png")) {
      return "image/png";
    } else if (file.endsWith("gif")) {
      return "image/gif";
    }
    return "text/plain";
  }

  private static boolean isBinary(final String file) {
    if (file.endsWith("js")) {
      return false;
    } else if (file.endsWith("css")) {
      return false;
    } else if (file.endsWith("html")) {
      return false;
    } else if (file.endsWith("jpg")) {
      return true;
    } else if (file.endsWith("png")) {
      return true;
    } else if (file.endsWith("gif")) {
      return true;
    }
    return false;
  }

  public String getPrintedPath() {
    return printedPath;
  }

}
