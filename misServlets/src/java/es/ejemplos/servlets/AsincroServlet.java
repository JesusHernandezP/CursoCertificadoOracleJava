/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ejemplos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
@WebServlet(name = "AsincroServlet", urlPatterns = {"/AsincroServlet"},
        asyncSupported = true) // Paso 0: Indicar que este Servlet será asíncrono
public class AsincroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("\t<head>");
            out.println("\t\t<title>Servlet AsincroServlet</title>");
            out.println("\t</head>");
            out.println("\t<body bgcolor='#ddcc99'>");
            out.println("\t\t<h2>Servlet AsincroServlet ubicado en " + request.getContextPath() + "</h2>");
            out.println("\t\t<p>Tarea realiz&aacute;ndose en segundo plano</p>");
            out.println("\t\t<hr/>");
            System.out.println(" > Hilo principal: " + Thread.currentThread().getName());
            out.println("\t\t<p>Antes del bucle</p>");
            final AsyncContext contextoAsincrono = request.startAsync(); // 1: Obtenemos un contexto "asíncrono"
            // 2: Tiempo máximo de espera o hasta que se llame a complete(). (30.000 por defecto). Paso opcional
            contextoAsincrono.setTimeout(30000);    // Comprobar la excepción que da si ponemos setTimeout a 20.000...

            // x: Añadidos eventos para avisar al usuario que la tarea lenta terminó
            contextoAsincrono.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    System.out.println(" - La tarea se ha completado -");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    System.out.println(" - Se ha excedido en tiempo");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });

            // 3: Al start() le pasamos un Runnable para ejecutar hilo paralelo con la tarea asíncrona y no pare el principal
            contextoAsincrono.start(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(" - Hilo tarea asíncrona: " + Thread.currentThread().getName());
                        try {
                            // Simulando tarea lenta
                            out.println(" i == " + i + "<br/>");
                            Thread.sleep(2000);
                        } catch (InterruptedException iex) {}
                    }
                    // Completa operación asíncrona, cerrando la response
                    // Si hemos registrado un Listener, será invocado 
                    out.flush();
                    contextoAsincrono.complete();
                }
            });
            out.println("\t\t<p>fin del bucle</p>");
            out.println("\t\t<hr/>");
            out.println("\t\t<p><a href='index.html'>Volver al men&uacute; anterior</a></p>");
            out.println("\t</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
