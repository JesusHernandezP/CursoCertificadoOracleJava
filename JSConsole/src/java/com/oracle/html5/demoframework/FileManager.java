package com.oracle.html5.demoframework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
@Named("fileManager")
public class FileManager {

  private static final String prefix = "/home/oracle/demos";

  @Inject
  private ServletContext context;
  @Inject
  private HttpServletRequest request;

  public void writeContent(OutputStream out, DemoFile demoFile) {
    try (InputStream in = getContentStream(demoFile)) {
      write(out, in);
    } catch (Exception ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  void writeSolution(ServletOutputStream outputStream, DemoFile demoFile) {
    try (InputStream in = context.getResourceAsStream(demoFile.getSolutionPath())) {
      write(outputStream, in);
    } catch (Exception ex) {
      writeContent(outputStream, demoFile);
    }
  }

  public String getPrintVersion(DemoFile demoFile) {
    try (Reader reader = new InputStreamReader(context.getResourceAsStream(demoFile.getPrintedPath()))) {
      return read(reader);
    } catch (Exception ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  public String getContent(DemoFile demoFile) {
    try (Reader reader = new InputStreamReader(getContentStream(demoFile))) {
      return read(reader);
    } catch (Exception ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  public String getSolution(DemoFile demoFile) {
    try (Reader reader = new InputStreamReader(context.getResourceAsStream(demoFile.getSolutionPath()))) {
      return read(reader);
    } catch (Exception ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  public String getInstructions(Demo demo) {
    String instructionsPath = "/" + demo.getPath() + demo.getInstructions();
    try (StringWriter writer = new StringWriter();
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getResourceAsStream(instructionsPath)))) {
      String line;
      boolean writing = false;
      while ((line = reader.readLine()) != null) {
        if (line.contains("<body>")) {
          writing = true;
        } else if (line.contains("</body>")) {
          writing = false;
        } else if (writing) {
          writer.write(line);
          writer.write("\n");
        }
      }
      return writer.toString();
    } catch (Exception ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  private InputStream getContentStream(DemoFile demoFile) throws FileNotFoundException {
    File file = new File(getLocalPath(demoFile));
    if (file.exists()) {
      return new FileInputStream(file);
    } else {
      return context.getResourceAsStream(demoFile.getOriginalPath());
    }
  }

  private String read(Reader reader) {
    try (StringWriter writer = new StringWriter()) {
      write(writer, reader);
      return writer.toString();
    } catch (IOException ex) {
      Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "";
  }

  public void write(Writer writer, Reader reader) throws IOException {
    int read;
    while ((read = reader.read()) != -1) {
      writer.write(read);
    }
  }

  void save(DemoFile demoFile, InputStream in) throws IOException {
    File file = new File(getLocalPath(demoFile));
    file.getParentFile().mkdirs();
    try (FileOutputStream out = new FileOutputStream(file)) {
      byte[] buffer = new byte[2048];
      int read;
      while ((read = in.read(buffer)) > 0) {
        out.write(buffer, 0, read);
      }
    }
  }

  void restore(DemoFile demoFile) {
    File file = new File(getLocalPath(demoFile));
    if (file.exists()) {
      System.out.println("Deleted: " + file.getAbsolutePath());
      file.delete();
    }
    if (isLocal()) {
      init(demoFile);
    }
  }

  public void init(DemoFile demoFile) {
    File file = new File(prefix + "/local" + demoFile.getOriginalPath());
    if (!file.exists()) {
      file.getParentFile().mkdirs();
      try (OutputStream out = new FileOutputStream(file);
              InputStream in = context.getResourceAsStream(demoFile.getOriginalPath())) {
        byte[] buffer = new byte[1024 * 32];
        int read;
        while ((read = in.read(buffer)) > 0) {
          out.write(buffer, 0, read);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  private String getLocalPath(DemoFile demoFile) {
    boolean local = isLocal();
    String user = request.getRemoteHost();
    user = user.replaceAll("\\:", "-");
    return prefix + "/" + (local ? "local" : user) + demoFile.getOriginalPath();
  }

  private boolean isLocal() {
    if (request.getRequestURL().toString().startsWith("http://localhost")) {
      return true;
    }
    return request.getLocalAddr().equals(request.getRemoteAddr());
  }

  private void write(OutputStream out, InputStream in) throws IOException {
    int read = 0;
    while ((read = in.read()) >= 0) {
      out.write(read);
    }
  }

}
