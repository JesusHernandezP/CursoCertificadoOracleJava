package es.ejemplos.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Pedro
 */
@WebListener // (en web.xml)
public class WebAppServletListener implements ServletContextListener {
    private boolean isActive;
    private ServletContext context;
    
    /**
     * Se trata de grabar un dato y sea accedido desde un servlet de este Contexto
     * @param sce 
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        isActive = true;
        context = sce.getServletContext();
        context.setAttribute("misServlets", isActive);
        System.out.println(" > Aplicación web " + this.context.getContextPath() + " iniciada:");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        isActive = false;
        System.out.println(" > Aplicacion web " + context.getContextPath() + " detenida");
    }
    
}
