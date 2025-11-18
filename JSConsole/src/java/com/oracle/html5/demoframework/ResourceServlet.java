package com.oracle.html5.demoframework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResourceServlet")
public class ResourceServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    final String file = request.getParameter("file");
    String type = request.getParameter("type");
    if (type == null) {
      type = DemoFile.getContentType(file);
    }
    response.setContentType(type);
    if(getServletContext().getResource(file)==null){
      response.setStatus(404);
      return;
    }
    try (OutputStream out = response.getOutputStream();
            InputStream in = getServletContext().getResourceAsStream(file)) {
      byte[] buffer = new byte[2048];
      int read;
      while ((read = in.read(buffer)) > 0) {
        out.write(buffer, 0, read);
      }
    }catch(FileNotFoundException ex){
      response.setStatus(404);
    }catch(IOException ex){
      response.setStatus(500);
    }
  }
}
