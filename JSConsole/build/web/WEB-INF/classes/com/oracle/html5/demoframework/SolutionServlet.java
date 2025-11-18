package com.oracle.html5.demoframework;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SolutionServlet", urlPatterns = {"/solution/*"})
public class SolutionServlet extends HttpServlet {

  @Inject
  private DemoList demoList;
  @Inject
  private FileManager fileManager;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String uri = request.getRequestURI();
    String requestedFile = uri.substring(uri.indexOf("view/") + 4);
    printFile(response, requestedFile);
  }

  public void printFile(HttpServletResponse response, String requestedFile) throws IOException {
    DemoFile demoFile = demoList.getFile(requestedFile);
    response.setContentType(demoFile.getContentType());
    fileManager.writeSolution(response.getOutputStream(), demoFile);
  }
}
