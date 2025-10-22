package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Servlet 3/12)
 * Este ejemplo muestra algunos métodos útiles de HttpServletRequest y su clase
 * padre. Representa la request (petición) obtenida desde el lado cliente
 * @author Pedro Andrés Díaz Gómez
 */
@WebServlet(name = "InfoPetiServlet", urlPatterns = {"/InfoPetiServlet"})
public class InfoPetiServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");	// Tipo MIME
        response.setDateHeader("Fecha", System.currentTimeMillis());
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("\t<head>");
            out.println("\t\t<title>Información de la Petición</title>");
            out.println("\t\t<link rel='stylesheet' href='estilos.css' type='text/css'/>");
            out.println("\t</head>");
            out.println("\t<body>"); // class='colVER'>");
            out.println("\t\t<h2>Servlet InfoPetiServlet ubicado en " + request.getContextPath() + "</h2>");
            out.println("\t\t<h3>Información de la petición</h3>");
            out.println("\t\tMétodo: " + request.getMethod() + "<br>");
            out.println("\t\tRequest URI: " + request.getRequestURI() + "<br>");
            out.println("\t\tRequest URL: " + request.getRequestURL() + "<br>");
            out.println("\t\tProtocolo: " + request.getProtocol() + "<br>");
            out.println("\t\tEsquema: " + request.getScheme() + "<br>");
            out.println("\t\tContextPath: " + request.getContextPath() + "<br>");
            out.println("\t\tServletPath: " + request.getServletPath() + "<br>");
            out.println("\t\tContentLength: " + request.getContentLength() + "<br>");
            out.println("\t\tContentType: " + request.getContentType() + "<br>");
            out.println("\t\tLocale: " + request.getLocale().getDisplayLanguage() + "<br>");
            out.println("\t\tPathInfo: " + request.getPathInfo() + "<br>");
            out.println("\t\tQuery string: " + request.getQueryString() + "<br>");
            out.println("\t\tRemote Address: " + request.getRemoteAddr() + "<br>");
            out.println("\t\tNombre del servidor: " + request.getServerName() + "<br>");
            out.println("\t\tPuerto: " + request.getServerPort() + "<br>");
            out.println("\t\tRemote Host: " + request.getRemoteHost() + "<br>");
            out.println("\t\t<h3>Cabeceras de la petición: </h3>");

             /* Nombres de las cabeceras (head) de la petición */
            out.println("\t\t<table border='1' align='center'>\n"
                    + "\t\t\t<tr bgcolor='#ffad00'>"
                    + "<th>Nombre cabecera</th><th>Valor</th></tr>");

            Enumeration<String> nomCabeceras = request.getHeaderNames();

            while (nomCabeceras.hasMoreElements()) {
                String nombre = nomCabeceras.nextElement();
                out.println("\t\t\t<tr><td>" + nombre + "</td>" + 
                        "<td>" + request.getHeader(nombre) + "</td></tr>");
            }
            
            /* Valores de las cabeceras (HEAD) de la petición */
            out.println("\t\t</table>");
            // out.println("Valor de upgrade-insecure-requests: " + request.getIntHeader("upgrade-insecure-requests"));
            out.println("\t\t<p><a href='index.html'>Volver al menú; anterior</a></p>");
            out.println("\t</body>");
            out.println("</html>");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);	// También por aquí es válido acceso
    }
}
