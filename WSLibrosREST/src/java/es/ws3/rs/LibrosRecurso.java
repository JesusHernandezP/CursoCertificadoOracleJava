package es.ws3.rs; 
 
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/* imports...  */ 
 
/** 
 * REST Web Service 
 */ 
@Path("LibrosRecurso") 
public class LibrosRecurso { 
 
    @Context 
    private UriInfo context; 
 
    private static List<Libro> listaLibros = new ArrayList(); 
 
    public LibrosRecurso() { 
        // No iniciar aquí el ArrayList, ya que se ejecutará en cada petición… 
    } 
 
    @GET 
    @Path("/libros") 
    public List<Libro> getLibros() { 
        return listaLibros; 
    } 
 
    @GET 
    @Path("/libro/{cod}") 
    public Libro getLibro(@PathParam("cod") int cod){ 
        Libro libro = null; 
        for(Libro l: listaLibros){ 
            if (l.getCodigo() == cod){ 
                libro = l; 
            } 
        } 
        return libro; 
    } 
     
    @POST 
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public Response addLibro( 
         @FormParam("codigo") int codigo, 
         @FormParam("titulo") String titulo, 
          @FormParam("autor") String autor, 
          @FormParam("precio") double precio) { 
        Libro libro = new Libro(codigo, titulo, autor, precio); 
        listaLibros.add(libro); 
        String linea = String.format("%d,%s,%s,%f",codigo, titulo, autor, precio); 
        System.out.println(" > " + linea); 
        return Response.ok(libro).build(); 
    } 
}