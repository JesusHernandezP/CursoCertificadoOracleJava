package com.oracle.html5.demoframework;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RevertServlet", urlPatterns = {"/revert/*"})
public class RevertServlet extends HttpServlet {

  @Inject
  private DemoList demoList;
  @Inject
  private FileManager fileManager;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String uri = request.getRequestURI();
    String requestedFile = uri.substring(uri.indexOf("revert/") + 7);
    Demo demo = demoList.getDemo(requestedFile);
    for (DemoFile file : demo.getFiles()) {
      fileManager.restore(file);
    }
    response.sendRedirect("/JSConsole/");
  }
}
