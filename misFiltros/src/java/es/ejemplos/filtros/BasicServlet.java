package es.ejemplos.filtros;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BasicServlet.java, v. 1.0
 * @author Pedro Andrés Díaz Gómez
 */
@WebServlet(name = "BasicServlet", urlPatterns = {"/BasicServlet"})
public class BasicServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BasicServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet BasicServlet at " + request.getContextPath() + "</h2>");
            out.println("<p>El parámetro nombre vale: " +request.getParameter("nom") + "</p>");
            out.println("<p>El parámetro apellido vale: " +request.getParameter("ape") + "</p>");
            out.println("<p>El atributo nombre vale: " +request.getAttribute("nom") + "</p>");
            out.println("<p>El atributo apellido vale: " +request.getAttribute("ape") + "</p>");
            out.println("<p><a href='index.jsp'>Volver a la página inicial</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet. versión 1.0";
    }
}
