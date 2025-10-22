package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HolaMundoServlet", urlPatterns = {"/HolaMundoServlet"})
public class HolaMundoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Buena práctica (o usar init sin parámetros)
        System.out.println("\tEl servlet HolaMundoServlet se ha iniciado...");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");    // MIME Type
        LocalDate fecha = LocalDate.now();  // Utilizando los nuevos objetos
        LocalTime hora = LocalTime.now();   // de fecha y hora de Java 8.
        Locale miPais = new Locale("es", "ES");
        try (PrintWriter out = res.getWriter()) { // Try with resources (Java8)
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"es\">");
            out.println("\t<head><title>HolaMundoServlet</title>\n"
                    + "\t<style>\n\t\tbody {background-color: #cc8866}\n\t</style>\n\t</head>");
            out.println("\t<body>");
            out.println("\t\t<h2>Servlet HolaMundoServlet ubicado en " + req.getContextPath() + "</h2>");
            out.println("\t\t<h1><strong>&iexcl;Hola, Mundo!</strong></h1>");
            out.println("\t\t<hr/>");
            out.println("\t\t<font size='5' color='#1111ee'>Ejemplo simple de un servlet<br/>");
            out.println("\t\tdesplegado desde el nodo " + req.getServerName() + 
                        "<br>Método http utilizado: " + req.getMethod() +
                        ".<br>Probando fechas Java 8</font>");
            out.println("\t\t<hr/>");
            out.println("\t\tFin del ejemplo hecho por Pedro, ejecutado el " 
                + fecha.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", miPais)));
            out.println("\t\t<br/>realizado a las " + hora.format(DateTimeFormatter.ofPattern("HH:mm:ss", miPais)));
            out.println("\t\t<p>Usuario que invoca: " + req.getRemoteUser() + "</p>"); // Sale null por no haber autenticado
            out.println("\t\t<p><a href='index.html'>Volver al menú anterior</a></p>");
            out.println("\t</body>\n</html>");
        }
    }

    @Override
    public void destroy() {
        System.out.println("\tEl servlet HolaMundoServlet se ha destruido...");
    }
}
