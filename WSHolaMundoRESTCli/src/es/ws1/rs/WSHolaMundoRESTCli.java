package es.ws1.rs;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WSHolaMundoRESTCli {

    public static void main(String[] args) throws MalformedURLException, IOException {
        String contextURL = "http://localhost:8080/WSHolaMundoREST";
        String resourcePath = "/webresources";
        String requestPath = "/generic";
        String urlString = contextURL + resourcePath + requestPath;
        URL url = new URL(urlString);
        InputStream resultado =  url.openStream();
        Scanner scanner = new Scanner(resultado);
        
     
        System.out.println("resultado GET:  " + scanner.nextLine()); 
    }
}
