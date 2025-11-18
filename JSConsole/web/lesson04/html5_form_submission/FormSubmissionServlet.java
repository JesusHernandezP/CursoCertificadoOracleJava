package lesson04.html5_form_submission;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "FormSubmissionServlet", urlPatterns = {"/FormSubmissionServlet"})
@MultipartConfig
public class FormSubmissionServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet FormSubmissionServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Parameters received: </h1>");
      Enumeration e = request.getParameterNames();
      while (e.hasMoreElements()) {
        Object obj = e.nextElement();
        String fieldName = (String) obj;
        String fieldValue = request.getParameter(fieldName);
        out.println(fieldName + " : " + fieldValue + "<br>");
      }
      Part filePart = request.getPart("file");
      String fileText = getFileText(filePart);
      out.println(filePart.getName() + " : " + fileText + "<br>");
      // For multiple files selected
            /*for (Part p : request.getParts()) {
       out.println(p.getName() + " : " + p.getInputStream().toString() + "<br>");
       }*/
      out.println("</body>");
      out.println("</html>");
    }
  }

  private static String getFileText(Part filePart) {
    String uploadedText = "";
    if (null != filePart) {
      try {
        InputStream fileContent = filePart.getInputStream();
        uploadedText = new Scanner(fileContent).
                useDelimiter("\\A").next();
      } catch (IOException ex) {
      }
    }
    return uploadedText;
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
