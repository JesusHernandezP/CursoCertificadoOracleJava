package com.oracle.html5.rest;

import java.io.IOException;
import java.util.Arrays;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class XSSFilter implements ContainerResponseFilter {

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    responseContext.getHeaders().put("Access-Control-Allow-Origin", Arrays.asList(new Object[]{"*"}));
    responseContext.getHeaders().put("Access-Control-Allow-Headers", Arrays.asList(new Object[]{"content-type", "Origin", "X-Requested-With", "Accept"}));
    responseContext.getHeaders().put("Access-Control-Allow-Methods", Arrays.asList(new Object[]{"POST", "GET", "DELETE", "PUT"}));
  }

}
