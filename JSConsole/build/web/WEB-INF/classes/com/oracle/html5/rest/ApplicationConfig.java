package com.oracle.html5.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    resources.add(CarsResource.class);
    resources.add(RestaurantsResource.class);
    resources.add(XSSFilter.class);
    //resources.add(AuthenticationFilter.class);
    try {
      Class<?> jsonProvider = Class.forName("org.glassfish.jersey.jackson.JacksonFeature");
      // Class<?> jsonProvider = Class.forName("org.glassfish.jersey.moxy.json.MoxyJsonFeature");
      // Class<?> jsonProvider = Class.forName("org.glassfish.jersey.jettison.JettisonFeature");
      resources.add(jsonProvider);
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    return resources;
  }
}
