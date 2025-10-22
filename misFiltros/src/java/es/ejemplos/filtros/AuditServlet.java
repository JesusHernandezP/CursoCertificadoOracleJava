package es.ejemplos.filtros;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet AuditServlet, v. 1.0
 * @author Pedro Andrés Díaz Gómez
 */
@WebServlet(name = "AuditServlet", urlPatterns = {"/AuditServlet"})
public class AuditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet AuditServlet at " + request.getContextPath() + "</h2>");
            out.println("<p>AuditFilter indica " + this.getServletContext().getAttribute("contador") + " visitas a este Servlet</p>");
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
        return this.getServletName();
    }
}
