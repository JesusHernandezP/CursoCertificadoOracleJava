package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ejemplo simple de proceso de Cookies. Este Servlet los lee, otro los crea
 * @version 2.0, Jun. 2017
 * @author Pedro
 */
@WebServlet(name = "LeeCookieServlet", urlPatterns = {"/LeeCookieServlet"})
public class LeeCookieServlet extends HttpServlet {

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
        // Acceder a las cookies de la cabecera de la petición HTTP
        Cookie[] cookies = request.getCookies();/*PUEDE ESTAR VACÍO...*/
        String nombre, valor;
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<html lang=\"es\">");
            out.println("<head><title>Cookies</title></head>");
            out.println("<body bgcolor='#aaaa99'>");
            out.println("<h2>Leyendo Cookies...</h2><br/>");

            if (cookies == null) {
                out.println("-- No se encontraron cookies grabadas por esta aplicaci&oacute;n --");
            } else {
                // Mostrar estas cookies. Ojo, si no hay almacenadas
                out.println("<strong>");
                for (int i = 0; i < cookies.length; i++) {
                    nombre = cookies[i].getName();
                    valor = cookies[i].getValue();
                    out.println("Nombre de Cookie = " + nombre
                            + "; valor = " + valor
                            + "; ruta = " + cookies[i].getPath()
                            + "; caducidad = " + cookies[i].getMaxAge()
                            + "<br/>");
                    out.println("</strong>");
                }
            }
            out.println("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.println("<br/></body></html>");
        }
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
