package es.control; 
 
import es.model.LibrosBean; 
import java.io.IOException; 
import java.io.PrintWriter; 
import javax.inject.Inject; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 

@WebServlet(name = "ControlServlet", urlPatterns = {"/ControlServlet"}) 
public class ControlServlet extends HttpServlet { 
    @Inject  
    LibrosBean librosBean; 
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        try (PrintWriter out = response.getWriter()) { 
            out.println("<!DOCTYPE html>"); 
            out.println("<html>"); 
            out.println("<head>"); 
            out.println("<title>Servlet ControlServlet</title>");             
            out.println("</head>"); 
            out.println("<body>"); 
            out.println("<h2>Servlet ControlServlet at " + request.getContextPath() + "</h2>"); 
            String opcion = request.getParameter("opcion"); 
            if (opcion.equals("Grabar")){ 
                System.out.println("> Se detecta operación grabar libro..."); 
                out.println("has pulsado grabar<br>"); 
                String titulo = request.getParameter("titulo"); 
                String autor  = request.getParameter("autor"); 
                if (titulo.length() > 0 && autor.length() > 0){ 
                    librosBean.inserta(titulo, autor); 
                    out.println("Se ha añadido un libro a la lista<br>"); 
                } 
                 
            }else if (opcion.equals("Listar")){ 
                System.out.println("> Se detecta listar; vamos a listado.jsp..."); 
                getServletContext().getRequestDispatcher("/listado.jsp").forward(request, 
response); 
            } 
            out.println("<a href='index.html'>Volver a la página de inicio</a>"); 
            out.println("</body>"); 
            out.println("</html>"); 
        } 
    } 
 
  @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        processRequest(request, response); 
    } 
} 
 
 

 
