package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "CarritoServlet2", urlPatterns = {"/CarritoServlet2"}, 
        initParams = {
            @WebInitParam(name = "empresa", value = "Papelería el Servlet"),
            @WebInitParam(name = "precioCuad", value = "1.5"),
            @WebInitParam(name = "precioBoli", value = "1")})
public class CarritoServlet2 extends HttpServlet {
    private float precioCuad;
    private float precioBoli;
    private String empresa;
    
    // Inicialización del Servlet
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        /*** Lectura de parámetros de inicialización del servlet ***/
        Enumeration<String> params = (Enumeration<String>) this.getInitParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement();
            System.out.println(name + " -> " + getInitParameter(name));
        }
        empresa = this.getInitParameter("empresa");
        precioCuad = Float.parseFloat(this.getInitParameter("precioCuad"));
        precioBoli = Float.parseFloat(this.getInitParameter("precioBoli"));
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carrito de la compra (1)</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet Carrito de la compra (2) en " + request.getContextPath() + "</h2>");
            out.println("<hr/>");
            out.println("<form method = 'post'>");
            out.println("<input type='submit' name='cuad' value='Comprar cuaderno'/><br/>");
            out.println("<input type='submit' name='boli' value='Comprar bolígrafo'/><br/>");
            out.println("<input type='submit' name='ver' value='Ver contenido carrito'/><br/>");
            out.println("<input type='submit' name='com' value='Adquirir contenido'/><br/>");
            out.println("</form><hr/>");
            out.println("<p>Ejemplo de Servlet con sesiones http</p>");
            out.println("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.println("</body>");
            out.println("</html>");
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
        StringBuilder html = new StringBuilder();
        HttpSession sesion = request.getSession(true); 
        String idSesion = ""; // JSESSIONID
        
        // Si es la primera vez, iniciamos la sesión
        if (sesion.isNew()){
            sesion.setAttribute("cuad", 0);
            sesion.setAttribute("boli", 0);
            idSesion = sesion.getId();
            System.out.println(" > La sesion Carrito1 vale: " + idSesion);
        }
        
        // Recogemos antiguos valores de elementos de sesiones previas
        int cuad = (int) sesion.getAttribute("cuad");
        int boli = (int) sesion.getAttribute("boli");
        
        if (request.getParameter("cuad") != null){
            cuad++;
            sesion.setAttribute("cuad", cuad);
            html.append("Compraste un cuaderno. Tienes <strong>")
                    .append(cuad).append("</strong>").append(" total ")
                    .append(cuad * precioCuad).append(" &euro;");
            
        }else if (request.getParameter("boli") != null){
            boli++;
            sesion.setAttribute("boli", boli);
            html.append("Compraste un bol&iacute;grafo. Tienes <strong>")
                    .append(boli).append("</strong>").append(" total ")
                    .append(boli * precioBoli).append(" &euro;");
        }else if (request.getParameter("com") != null){
            sesion.invalidate();
            html.append("Compra aceptada. Contenido: <br/>").append("<strong><p>")
                    .append(cuad).append(" cuaderno(s)</strong><br/><strong>")
                    .append(boli).append(" bolírafo(s)</strong><br/>")
                    .append("Total: ").append(precioCuad * cuad + precioBoli * boli)
                    .append(" &euro;</p>");
            
        }else if (request.getParameter("ver") != null){
            html.append("Tienes <strong> ").append(cuad).append(" cuadernos</strong>")
                    .append(" y ").append(boli)
                    .append("<strong> bol&iacute;grafo(s)</strong> en tu carrito, ")
                    .append("total: ").append(precioCuad * cuad + precioBoli * boli)
                    .append(" &euro;</p>");
        }
        
        // Parte común de la página dinámica que se envía al cliente
        response.setHeader("pragma", "no-cache"); // No actualizar de la caché
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Respuesta del carrito</title></head>");
            out.println("<body bgcolor='ccffcc' text='black'>");
            out.println("<h2>" + empresa + " (Pedro, v. 3.0)</h2>");
            out.println(html);
            out.println("<hr><a href='" + request.getRequestURI() 
                    + "'>Volver a la tienda</a></body></html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "CarritoServlet2";
    }// </editor-fold>
}