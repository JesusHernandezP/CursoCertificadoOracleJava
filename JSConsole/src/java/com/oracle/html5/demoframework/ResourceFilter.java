package com.oracle.html5.demoframework;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "ResourceFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class ResourceFilter implements Filter {

  public ResourceFilter() {
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (req instanceof HttpServletRequest) {
      HttpServletRequest request = (HttpServletRequest) req;
      if (request.getRequestURI().endsWith("/res")) {
        request.getServletContext().getNamedDispatcher("ResourceServlet").forward(req, response);
        return;
      }
    }
    chain.doFilter(req, response);
  }

  @Override
  public void destroy() {
  }

}
