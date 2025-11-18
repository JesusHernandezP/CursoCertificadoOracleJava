package com.oracle.html5.rest;

import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ClientRequestFilter, ContainerRequestFilter {

  @Override
  public void filter(ClientRequestContext requestContext) throws IOException {
    requestContext.getHeaders().add("API-NAME", "dev");
    requestContext.getHeaders().add("API-KEY", "12345");
  }

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String name = requestContext.getHeaderString("API-NAME");
    String key = requestContext.getHeaderString("API-KEY");
    if (!validateAPIKey(name, key)) {
      requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
    }
  }

  public boolean validateAPIKey(String name, String key) {
    return "dev".equals(name) && "12345".equals(key);
  }
}
