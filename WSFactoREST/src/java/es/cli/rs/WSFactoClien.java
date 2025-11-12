package es.cli.rs;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class WSFactoClien {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WSFactoREST/webresources";

    public WSFactoClien() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("factorial");
    }

    public String factorial(String base) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (base != null) {
            resource = resource.queryParam("base", base);
        }
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void close() {
        client.close();
    }

    public static void main(String[] args) {
        WSFactoClien client = new WSFactoClien();
        Object response = client.factorial("6");// Calculamos factorial de 6 (5040) 
        System.out.println(response); // Se imprime el código HTML 
        client.close();
    }

   
}
