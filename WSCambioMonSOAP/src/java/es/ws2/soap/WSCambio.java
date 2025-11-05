package es.ws2.soap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(targetNamespace = "http://DesarrollodeserviciosWebSOAPysusclientes.ws2.es" , serviceName = "WSCambio")
public class WSCambio {
 static final double VALORDOLAR = 0.936;
 static final double VALOREURO = 1.067;
 
 @WebMethod(operationName = "eurosAdolares")
 public double eurosAdolares(@WebParam(name = "euros") int euros) {
 return euros * VALORDOLAR;
 }

 @WebMethod(operationName = "dolaresAeuros")
 public double dolaresAeuros(@WebParam(name = "dolares") int dolares) {
 return dolares * VALOREURO;
 }
}
