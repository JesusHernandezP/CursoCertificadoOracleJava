package com.oracle.html5.demoframework;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResetServlet", urlPatterns = {"/reset"})
public class ResetServlet extends HttpServlet {

  @Inject
  private DemoList demoList;
  @Inject
  private FileManager fileManager;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    deleteFile(demoList.getDemos());
    demoList.init();
    deleteFile(demoList.getDemos());
    response.sendRedirect("/JSConsole/");
  }

  void deleteFile(Iterable<Demo> demos) {
    for (Demo demo : demos) {
      deleteFile(demo.getDemos());
      for (DemoFile file : demo.getFiles()) {
        fileManager.restore(file);
      }
    }
  }
}
