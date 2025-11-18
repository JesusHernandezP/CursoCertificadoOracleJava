package es.ws3.soap;

import es.ws.soap.ServOper;
import es.ws.soap.ServOper_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

@WebServlet(name = "CalculaServlet", urlPatterns = {"/calcula"})
public class CalculaServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation
            = "http://localhost:8080/WSServOper/ServOper?wsdl")
    private ServOper_Service service; // Servicio Web inyectado

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        double resultado = 0;
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculaServlet at " + request.getContextPath()
                    + "</h1>");
            ServOper port;
            port = service.getServOperPort();
            double n1 = Integer.parseInt(request.getParameter("n1"));
            double n2 = Integer.parseInt(request.getParameter("n2"));
            String oper = request.getParameter("oper");

            switch (oper) {
                case "+":
                    resultado = port.suma(n1, n2);
//                    System.out.println(">><h1> </h1>" + resultado);
                    break;
                case "-":
                    resultado = port.suma(n1, n2);
                    System.out.println(">> " + resultado);
                    break;
                case "/":
                    resultado = port.suma(n1, n2);
                    System.out.println(">> " + resultado);
                    break;
                case "*":
                    resultado = port.suma(n1, n2);
                    System.out.println(">> " + resultado);
                    break;

            }
        }
    }

    private double divi(double n1, double n2) {
      ServOper port = service.getServOperPort();
        return port.divi(n1, n2);
    }

    private double multi(double n1, double n2) {
        
        ServOper port = service.getServOperPort();
        return port.multi(n1, n2);
    }

    private double resta(double n1, double n2) {
        
        ServOper port = service.getServOperPort();
        return port.resta(n1, n2);
    }

    private double suma(double n1, double n2) {
     
        ServOper port = service.getServOperPort();
        return port.suma(n1, n2);
    }

   
    
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}


}
