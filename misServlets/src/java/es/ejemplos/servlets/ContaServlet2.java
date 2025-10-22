package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Servlet 2/8)
 * Ejemplo de Servlet con un contador de visitas en una variable miembro
 * @author Pedro Andrés Díaz Gómez
 */
@WebServlet(name = "ContaServlet2", urlPatterns = {"/ContaServlet2"})
public class ContaServlet2 extends HttpServlet {
    private int contador;
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        System.out.println("ContaServlet2 se ha iniciado");
        //contador = 0;
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
        /** nueva versión 2 **/
        /**
         * Ahora la idea es que el contador sea independiente para cada usuario. 
         * Lo guardamos en una cookie
         */
        Cookie[] cookies = request.getCookies();
        String nombre="", valor="";
        if (cookies.length > 0) {
            nombre = cookies[0].getName();
            valor = cookies[0].getValue();
        }
        try {
        if (valor != null && !valor.equals("")){
            contador = Integer.parseInt(valor);
        }else{
            contador = 0;
        }
        }catch(NumberFormatException nfe){
            contador = 0;
        }
        /**********************/
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet ContaServlet ubicado en " + request.getContextPath() + "</h2>");
            out.println("<p>El servlet ha sido invocado " + 
                    contador + (contador == 1 ? " vez": " veces") + "</p>");
            out.println("<p>Este servlet define una variable contador que guarda e incrementa<br/>");
            out.println("el n&uacute;mero de accesos realizados desde navegadores web<br/>");
            out.println("por distintas peticiones y distintos clientes.</p>");
            out.println("<p>Se trata de definir la variable:");
            out.println("<p>&nbsp;&nbsp;<code>int contador = 0;</code></p>");
            out.println("en alguna parte del programa e incrementarla.<br/>Se prueba pulsando <strong>F5</strong>");
            out.println(" o reintroduciendo la URL en la barra del navegador.</p>");
            out.println("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.println("</body>");
            out.println("</html>");
            contador++;
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
        return "ContaServlet, por Pedro Díaz Gómez, version 2.0, Madrid, Julio de 2016";
    }// </editor-fold>
    @Override
    public void destroy(){
        System.out.println("ContaServlet ha finalizado");
    }
}