package com.oracle.html5.demoframework;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditServlet", urlPatterns = {"/edit/*"})
public class EditServlet extends HttpServlet {

  @Inject
  private DemoList demoList;
  @Inject
  private DemoEditor editor;
  @Inject
  private FileManager fileManager;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String uri = request.getRequestURI();
    String requestedFile = uri.substring(uri.indexOf("edit/") + 5);
    Demo demo = demoList.getDemo(requestedFile);
    editor.setSelected(demo);
    request.getRequestDispatcher("/WEB-INF/editor.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (InputStream in = req.getInputStream()) {
      String uri = req.getRequestURI();
      String file = uri.substring(uri.indexOf("edit/") + 4);
      DemoFile demoFile = demoList.getFile(file);
      if (demoFile.isBinary()) {
        throw new ServletException("Cant save a binary file!");
      }
      if (req.getContentLengthLong() == 0) {
        fileManager.restore(demoFile);
      } else {
        fileManager.save(demoFile, in);
      }
      printFile(resp, file);
    } catch (Exception e) {
      e.printStackTrace();
      resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    resp.setStatus(HttpServletResponse.SC_OK);
  }

  public void printFile(HttpServletResponse response, String requestedFile) throws IOException {
    DemoFile demoFile = demoList.getFile(requestedFile);
    response.setContentType(demoFile.getContentType());
    fileManager.writeContent(response.getOutputStream(), demoFile);
  }
}
