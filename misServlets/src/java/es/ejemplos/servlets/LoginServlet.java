package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Servlet 5/8) Este Servlet detalla la navegación entre una página html y el
 * procesamiento de un formulario de usuario desde peticiones GET y POST
 *
 * @author Pedro Andrés Díaz Gómez
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"},
        initParams = {
            @WebInitParam(name = "usuario", value = "invitado"),
            @WebInitParam(name = "contrasenia", value = "abc123")})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = "root";	// Conveniencia de usar variables locales en Servlets
        String contrasenia = "root";
        res.setContentType("text/html");
        try (PrintWriter out = res.getWriter()) {
            ServletConfig sc = this.getServletConfig();
            out.println("<html><head><title>Comprobando identidad</title></head>");
            out.println("<body>");
            out.println("<h2>Comprobando identidad...</h2><p/>");
            String lo = req.getParameter("NOM");
            String pa = req.getParameter("CON");

            if (lo.equals(login) && pa.equals(contrasenia)) {
                out.println("<h1><strong>Bienvenido al servidor, " + lo + "</strong></h1>");
            } else {	// Si la identidad no coincide con la del usuario habitual...
                if (lo.equals("") && pa.equals("")) { // Miro si está en blanco
                    lo = sc.getInitParameter("usuario"); // y asumo que es invitado
                    pa = sc.getInitParameter("contrasenia"); // leyéndolo de "web.xml" (parms. de contexto)
                    out.println("<h1><strong>Hola, " + lo + "</strong></h1>");
                } else {
                    out.println("<h1><strong>Fuera, intruso</strong></h1>");
                    out.println("<strong><h3>Acceso prohibido</h3></strong>");
                    //out.println("<a href='LoginServlet.html'>volver</a>");// Modo 1 de regresar al HTML (enlace a href)
                    //res.sendRedirect("LoginServlet.html");                // Modo 2 " " (response.sendRedirect())
                    //pw.println("<script>history.back(alert('Usuario incorrecto'))</script>");	// Modo 3 (history.back - javascript)
                                                                            // Modo 4: con forward
                    //RequestDispatcher rd = req.getRequestDispatcher("LoginServlet.html");
                    //rd.forward(req, res);
                }
            }
            out.println("<br>");
            String enlace = null;
            enlace = req.getRequestURI();
            out.println("&nbsp;&nbsp;<a href=\"" + enlace + ".html\">" + "Volver al formulario anterior</a>");
            out.println("<br>&nbsp;&nbsp;(Me voy a ir a: " + enlace + ")");
            out.println("\t\t<p><a href='index.html'>Volver al menú anterior</a></p>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        try (PrintWriter pw = res.getWriter()) {
            pw.println("<html><head><title>Comprobando identidad</title></head>");
            pw.println("<body bgcolor='ee8888'>");
            pw.println("<h2>Rechazado el acceso...</h2><p/>");
            pw.println("Prohibido el acceso a esta página <br/>");
            pw.println("desde otro sitio que no sea el formulario de entrada.<br/>");
            pw.println("Por favor, acceda a la pantalla de inicio desde el formulario...<p/>");
            pw.println("<a href=/misServlets/LoginServlet.html" + ">LoginServlet.html</a>");
            pw.println("</body></html>");
        }
    }

}/*
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Identificación</title>
        <link rel="stylesheet" href="estilos.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="Author" content="Pedro">
    </head>
    <!--<body bgcolor="#99ff66" -->
    <body class="fondoV">
        <h2>Validación</h2>
        <hr>
        <!-- No es recomendable utilizar rutas absolutas como esta: -->
        <form method="post" action="http://localhost:8080/misServlets/LoginServlet">
            Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="NOM"><br/>
            Contraseña:
            <input type="password" name="CON"/>
            <p>
            <input type="submit"/>
            </p>
        </form>
        <hr>
        <a href='index.html'>Volver al menú anterior</a>
    </body>
</html>
 */
