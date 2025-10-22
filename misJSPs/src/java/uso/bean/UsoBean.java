/*
 * UsoBean.java, Created on 19-sep-2014
 * Este bean simplemente describe una propiedad para utilizarla como
 * demostración de uso de la acción jsp:useBean
 */
package uso.bean;

import java.io.Serializable;

public class UsoBean implements Serializable {
    private static final long serialVersionUID = 4072024L;
    private String mensaje;

    // Constructor por defecto
    public UsoBean() {
        mensaje = "Saludo de inicio";
    }

    // Métodos set y get para asignar y recuperar el valor de la propiedad
    // mensaje, que se utilizará en la página JSP
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return (mensaje);
    }

    public String mensajeActual() {
        return ("El mensaje actual es este: " + mensaje);
    }
}
