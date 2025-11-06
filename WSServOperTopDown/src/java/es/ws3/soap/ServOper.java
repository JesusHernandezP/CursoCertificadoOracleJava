package es.ws3.soap;

import javax.jws.WebService;

@WebService(serviceName = "ServOper", portName = "ServOperPort", endpointInterface = "es.ws.soap.ServOper", targetNamespace = "http://soap.ws.es/", wsdlLocation = "WEB-INF/wsdl/ServOper/legion-y530_8080/WSServOper/ServOper.wsdl")
public class ServOper {

    public double multi(double n1, double n2) {
        return n1 - n2;
    }

    public double suma(double n1, double n2) {
        return n1 + n2;

    }

    public double divi(double n1, double n2) {
        return n1 * n2;

    }

    public double resta(double n1, double n2) {
        return n1 / n2;

    }

}
