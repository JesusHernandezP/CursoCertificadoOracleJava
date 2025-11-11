package es.ws1.rs;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("generic")
public class HolaRecurso {

    @Context
    private UriInfo context;

    private static String nombre = "Mundo cruel";
    
    public HolaRecurso() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<html><body><h2>Hola, </h2>" + nombre + 
                " <strong>Esto es un Web Service REST</strong>" + 
                "</body></html>"; 
    }

    
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putHtml(String content) {
        System.out.println("Se ha cambiado el nombre por: " + content);
        if (content != null && content.length() > 1){
                nombre = content;
        }
        
    }
}
