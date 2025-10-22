package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Servlet 4/8) 
 * Este Servlet detalla el uso de parámetros de Servlet y de Contexto
 * @author Pedro Andrés Díaz Gómez
 */
@WebServlet(name = "ContextServlet", urlPatterns = {"/ContextServlet"}, initParams = {
    @WebInitParam(name = "valornum", value = "100"),
    @WebInitParam(name = "perfil", value = "admin")})
public class ContextServlet extends HttpServlet {
    private ServletContext contexto = null;

    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);	// No olvidar enviar el parámetro al ancestro, o fallará el "contexto"...
        contexto = sc.getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        // contexto = getServletContext(); (Mejor en init(), para hacerlo sólo una vez)
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("\t<head>");
            out.println("\t\t<title>Informaci&oacute;n del Contexto</title>");
            out.println("\t</head>");
            out.println("\t<body bgcolor='#bbccbb'>");
            out.println("\t\t<h3>Variables de Contexto (ServletContext) " + 
                "y del Servlet (GenericServlet):</h3>");
            out.println("\t\t<hr/>");
            /* Leyendo parámetros del contexto*/
            Enumeration<String> enu;
            if (contexto == null) {
                out.println("\tNo hay variables asociadas a este contexto");
            } else {
                out.println("\t<p>Detectadas variables asociadas a este contexto</p>");
                enu = contexto.getInitParameterNames();
                String nomParam, valParam;
                while (enu.hasMoreElements()) {
                    nomParam = enu.nextElement();
                    valParam = contexto.getInitParameter(nomParam);
                    out.println("\t\t<li>" + nomParam + " = " + valParam + "</li>");
                }
            }

            /* Leyendo parámetros del Servlet */
            enu = this.getInitParameterNames(); // this = GenericServlet
            if (!enu.hasMoreElements()) {
                out.println("\tNo hay variables asociadas a este Servlet");
            } else {
                out.println("\t<p>Detectadas variables asociadas a este Servlet</p>");
                String nomParam, valParam;
                while (enu.hasMoreElements()) {
                    nomParam = enu.nextElement();
                    valParam = this.getInitParameter(nomParam);
                    out.println("\t\t<li>" + nomParam + " = " + valParam + "</li>");
                }
            }
            out.println("\t\t<hr/>");
            out.println("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.println("\t</body>");
            out.println("</html>");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);	// También por aquí es válido el acceso. Redigirimos al doGet()
    }
}
