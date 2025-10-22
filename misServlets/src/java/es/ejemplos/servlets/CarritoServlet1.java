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
import javax.servlet.http.HttpSession;

/**
 * CarritoServlet.java Ejemplo de aplicación web "Carrito de la compra", con
 * seguimiento de sesiones
 *
 * @author Pedro Díaz Gómez
 * @version 1.2
 */
@WebServlet(name = "CarritoServlet1", urlPatterns = {"/CarritoServlet1"})
public class CarritoServlet1 extends HttpServlet {

    /**
     * *************************************************************************
     * IMPORTANTE * Hacer una primera versión de este programa sin el dato de
     * precio que será añadido por los usuarios para obtener el total. Sustituir
     * el array de un elemento del método set/getAttribute por variables
     * primitivas de tipo int y double, pero es necesario grabar en ese caso en
     * la sesión los valores con setAttribute (cosa que con el array no es
     * necesario). Optimizar donde se crea oportuno.
     ***************************************************************************
     */
    private String usuario; // Prueba del contexto
    private String contrasenia;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // config = parámetro local
        /* Leyendo parámetros de contexto (en web.xml) */
        ServletContext contexto = config.getServletContext();
        usuario = contexto.getInitParameter("usuario");
        contrasenia = contexto.getInitParameter("contrasenia");
    }

    // Creamos desde aquí la página html que se envía al cliente y que
    // representa el formulario desde el que podrá comprar artículos.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.print("<html><head><title>Carrito de la compra (1)</title></head>");
            out.print("<body bgcolor='white' text='black'>");
            out.print("<h2>Servlet Carrito de la compra (1) en " + request.getContextPath() + "</h2>");
            out.print("<p>Usuario: " + usuario + "<br/>");
            out.print("Contraseña: " + contrasenia + "<br/>");
            out.print("</p><hr/>");
            out.print("<form method='post'>");
            out.print("<input type='submit' name='cuad' value='Comprar un cuaderno'/><br/>");
            out.print("<input type='submit' name='boli' value='Comprar un bolígrafo'/><br/>");
            out.print("<input type='submit' name='ver'  value='Ver contenido carrito'/><br/>");
            out.print("<input type='submit' name='com'  value='Adquirir contenido carrito'/><br/>");
            out.print("</form><hr width='20%' align='left'>");
            out.print("Ejemplo de servlets con sesiones y cookies");
            out.print("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.print("</body></html>");
        }
    }

    // Ahora procesamos los datos enviados por el formulario anterior a
    // partir del doGet
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mensa = "";
        HttpSession sesion = request.getSession(true); // Obtiene sesión o la crea si no existe
        String idSesion = "";

        // Si es la primera vez, inicializamos la sesión
        if (sesion.isNew()) {
            sesion.setAttribute("cuad", new int[]{0});
            sesion.setAttribute("boli", new int[]{0});
            idSesion = sesion.getId();
            System.out.println(" > La sesion Carrito2 vale: " + idSesion);
        }

        // Recogemos valores antiguos de elementos incluidos en sesiones previas
        int[] cuad = (int[]) sesion.getAttribute("cuad");
        int[] boli = (int[]) sesion.getAttribute("boli");

        //*******************************************************************//
        // Poner aquí las nuevas líneas para calcular el precio de la compra
        // Controlamos la acción solicitada a través del formulario
        if (request.getParameter("cuad") != null) {
            cuad[0]++;
            mensa = "Compraste un cuaderno. Tienes <strong>" + cuad[0] + "</strong>";
        } else if (request.getParameter("boli") != null) {
            boli[0]++;
            mensa = "Compraste un bol&iacute;grafo. Tienes <strong>" + boli[0]
                    + "</strong>";
        } // Opción de comprar el contenido del carrito
        else if (request.getParameter("com") != null) {
            sesion.invalidate();
            mensa = "Compra aceptada. Contenido:<br/>" + "<strong> " + cuad[0]
                    + " cuaderno(s)" + "</strong>" + "<br/><strong>" + boli[0]
                    + " bol&iacute;grafo(s)" + "</strong>" + "<br/>"
                    + "<p>Tu carrito de la compra est&aacute; vac&iacute;o.</p>";
        } // En cualquier otro caso, se muestra el contenido del carrito
        else {
            mensa = "Tienes<strong> " + cuad[0] + "</strong> cuaderno(s)" + " y<strong> "
                    + boli[0] + "</strong> bol&iacute;grafo(s) en tu carrito."
                    + "<br/>";
        }

        // Por último creamos la respuesta al cliente indicando el resultado
        response.setContentType("text/html");
        response.setHeader("pragma", "no-cache");	// Borramos el caché del navegador
        try (PrintWriter pw = response.getWriter()) {
            pw.println("<html><head><title>Respuesta del carrito</title></head>");
            pw.println("<body bgcolor='CCFFCC' text='black'");
            pw.println("link='blue' vlink='purple' alink='red'>");
            pw.println("<h1>Papeler&iacute;a El Servlet</h1>");
            pw.println(mensa);
            pw.println("<hr/><a href='" + request.getRequestURI()
                    + "'>Volver a la tienda</a></body></html>");
        }
    }
}
