package es.ejemplos.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtro BasicFilter.java, v. 1.0.
 * @author Pedro Andrés Díaz Gómez
 */
@WebFilter(filterName = "BasicFilter", urlPatterns = {"/BasicServlet"})
public class BasicFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        System.out.println(" > Filtro '" + filterConfig.getFilterName() + "' iniciado...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println(" > Método doFilter() de 'BasicFilter' realizado");

        if (request.getParameter("nom") == null || request.getParameter("ape") == null) {
            System.out.println("No se enviaron parámetros. Programa cancelado");
        } else {
            
            String nombre = request.getParameter("nom").toUpperCase();
            String apelli = request.getParameter("ape").toUpperCase();
            System.out.println("estableciendo atributos; nombre = " + nombre);
            request.setAttribute("nom", nombre);
            request.setAttribute("ape", apelli);
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println(" > El Filtro 'BasicFilter' se ha detenido");
    }
}
