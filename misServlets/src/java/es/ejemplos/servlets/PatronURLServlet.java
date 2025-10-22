package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PatronURLServlet (prueba de Servlet sin anotaciones)
 * @author Pedro
 */
public class PatronURLServlet extends HttpServlet {
    private ServletConfig config;
    private ServletContext context;
    @Override
    public void init(ServletConfig servletConfig) {
        this.config = servletConfig;
        this.context = config.getServletContext();
        System.out.println(" > Ejecutando el método \"init()\" de " + servletConfig.getServletName());
    }

    /**
     * **** EL MÉTODO service() tiene preferencia frente al doXXX() si están los 2
     *
     ******
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @Override protected void service(HttpServletRequest request,
     * HttpServletResponse response) throws ServletException, IOException {
     * PrintWriter out = response.getWriter(); out.println("<h2>Servlet
     * PatronURLServlet en " + request.getContextPath() + "</h2>");
     * out.println("
     * <p>
     * <strong>M&eacute;todo service()</strong></p>"); out.close();
     * System.out.println(" > Ejecutando el método service"); }
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws java.io.IOException
     * @throws ServletException if a servlet-specific error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println(" > Ejecutando el método processRequest()");
            // ¿Lo siguiente lee un parámetro del Servlet o del Contexto?
            String contra1 = config.getInitParameter("contrasenia"); // Lee del Servlet
            String contra2 = context.getInitParameter("contrasenia"); // Lee del Contexto
            
            System.out.println(" > Ejecutando processRequest");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PatronURLServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet " + config.getServletName() + " en " + request.getContextPath() + "</h2>");
            out.println("<p>La contrase&ntilde;a de Servlet leida es: <strong>" + contra1 + "</strong></p>");
            out.println("<p>La contrase&ntilde;a de Contexto leida es: <strong>" + contra2 + "</strong></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

// Probando si compila un constructor por defecto (SI)
    public PatronURLServlet() {
        this("mensaje", 10);
    }

    // Probando otro constructor con parámetros (SI)
    public PatronURLServlet(String ruta, int codigo) {
        System.out.println(" > Ejecutado constructor parametrizado\n con los datos " + ruta + " y " + codigo);
        System.out.println(" > este constructor se llamó desde el por defecto con this(String, int)");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        System.out.println(" > Ejecutando el método doGet()");
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
        System.out.println(" > Ejecutando el método doPost()");
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
