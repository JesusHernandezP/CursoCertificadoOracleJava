package es.ws2.soap;

import es.ws2.desarrollodeservicioswebsoapysusclientes.WSCambio;
import es.ws2.desarrollodeservicioswebsoapysusclientes.WSCambio_Service;

public class WSCambioMonCliAppTest {

    public static void main(String[] args) {
        System.out.printf("100 euros son %,.2f dólares.%n", dolaresAeuros(100));
        System.out.printf("100 dólares son %,.2f euros.%n", eurosAdolares(100));

    }

    private static double dolaresAeuros(int dolares) {
      WSCambio_Service service = new WSCambio_Service();
        WSCambio port = service.getWSCambioPort();
        return port.dolaresAeuros(dolares);
    }

    private static double eurosAdolares(int euros) {
      WSCambio_Service service = new WSCambio_Service();
        WSCambio port = service.getWSCambioPort();
        return port.eurosAdolares(euros);
    }

}
