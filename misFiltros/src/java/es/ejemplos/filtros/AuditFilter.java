package es.ejemplos.filtros;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "AuditFilter", urlPatterns = {"/AuditServlet"}, dispatcherTypes = {DispatcherType.REQUEST})
public class AuditFilter implements Filter {
    private FilterConfig filterConfig = null;
    private StringBuffer buf;
    private LocalDateTime ldt;
    private String ip;
    
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        buf = null;
        System.out.println(" > Filtro '" + filterConfig.getFilterName() + "' iniciado...");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        System.out.println(" > Filtro 'AuditFilter' invocado");
        if (filterConfig == null) {
            return;
        }
        buf = new StringBuffer();
        
        Integer conta;
        synchronized(this){
            conta = (Integer)filterConfig.getServletContext().getAttribute("contador");
            if (conta == null) { // La cuenta será 0 si el contenedor acaba de arrancar
                conta = 1;
            } else {
                conta = conta + 1;
            }
            ip = request.getRemoteAddr();
            ldt = LocalDateTime.now();
            buf.append("IP: ").append(ip).append("Fecha: ").append(ldt).append(", visitas: ").append(conta);
        }
        filterConfig.getServletContext().log(buf.toString());
        filterConfig.getServletContext().setAttribute("contador", conta);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {        
        System.out.println(" > El filtro 'AuditFilter' se ha detenido");
        this.filterConfig = null;
    }
}
