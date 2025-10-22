/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Ejemplo simple de proceso de Cookies. Este Servlet los crea, otro los lee
 * @author Pedro
 */
@WebServlet(name = "PonCookieServlet", urlPatterns = {"/PonCookieServlet"})
public class PonCookieServlet extends HttpServlet {

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
            // Leer el parámetro de la petición HTTP del cliente
            String nom = request.getParameter("nombre");
            String val = request.getParameter("valor");
            System.out.println(" > nom = " + nom);
            System.out.println(" > val = " + val);
            // Creamos a continuación la cookie

            Cookie cookie = new Cookie(nom, val);
            cookie.setMaxAge(500); // 5 minutos...
            // Añadir la cookie a la respuesta HTTP
            response.addCookie(cookie); 
            // Escribimos una salida hacia el navegador
            response.setContentType("text/html");
            out.println("<htlm lang=\"es\">");
            out.println("\t<head>\n\t<title>Cookies</title>\n\t</head>");
            out.println("\t<body class=\"fondoM\">");
            out.println("\t<h1>Servlet PonCookieServlet ubicado en " + request.getContextPath() + "</h1>");
            out.println("\t\t<h2>Utilizando Cookies</h2></p>");
            out.println("\t\t<strong>La cookie '" + nom + "' se guardado con: '" + val + "'</strong>");
            out.println("\t\t<p><a href='index.html'>Volver al menú anterior</a></p>");
            out.println("\t\t<br/>\n\t</body>\n</html>");
        }
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
        return "PonCookieServet, por Pedro Díaz 2020";
    }// </editor-fold>

}
/*
<html>
    <head>
        <title>PonCookie.html</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <div>TODO write content</div>
        <form name="formu1" method="post" action="PonCookieServlet">
            <strong>Introduce un valor para la Cookie: </strong><br/>
            <p>NOMBRE:<input type='text' name='nombre' size='25'></p>
            <p>VALOR&nbsp;:<input type='text' name="valor" size='20'></p>
            <input type="submit" value="Enviar">
            <input type="reset" value="Borrar">
        </form>
    </body>
</html>
*/