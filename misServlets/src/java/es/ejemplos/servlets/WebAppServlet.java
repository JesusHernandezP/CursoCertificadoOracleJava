/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Esta clase se apoya en el listener WebAppServletListener que carga un dato
 * en memoria al que accederá este Servlet y ver así la utilidad de Listeners.
 * @author Pedro
 */
@WebServlet(name = "WebAppServlet", urlPatterns = {"/WebAppServlet"})
public class WebAppServlet extends HttpServlet {
    private ServletConfig config;
    /**
     * 
     * @param config 
     * @throws javax.servlet.ServletException 
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init();
        this.config = config;
    }
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
        ServletContext contexto = config.getServletContext(); // Esto marcha
        try (PrintWriter out = response.getWriter()) {
            boolean valor = (Boolean) contexto.getAttribute("misServlets");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WebAppServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet WebAppServlet ubicado en " + request.getContextPath() + "</h2>");
            out.println("<p>Leyendo atributos inicializados por un ServletContextListener");
            out.println("<p>El dato misServlets vale: <strong>" + valor + "</strong></p>");
            out.println("<p>No olvides echar un vistazo a los mensajes<br/>");
            out.println("emitidos por el servidor de aplicaciones</p>");
            out.println("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.println("</body>");
            out.println("</html>");
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
