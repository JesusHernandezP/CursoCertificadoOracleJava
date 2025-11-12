package es.ws2.rs;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("factorial")
public class CalculoResource {

    @Context
    private UriInfo context;

    public CalculoResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String factorial(@QueryParam("base") Integer base) {
        long factorial = calculaFactorial(base); // delegamos la operación 
        return "<html><head><title>WSFactoREST</title></head>\n"
                + "<body><h3>La factorial de <strong>" + base + "</strong> es: "
                + factorial + "</h3>\n"
                + "<a href='/WSFactoREST/'>Volver</a></body>\n</html>\n";
    }

    private long calculaFactorial(int base) {
        if (base >= 1) {
            return calculaFactorial(base - 1) * base;
        }
        return 1;
    }

}
