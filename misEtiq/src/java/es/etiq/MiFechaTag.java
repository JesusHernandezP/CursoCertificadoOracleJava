package es.etiq;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MiFechaTag extends TagSupport {

    private int atrib1 = 12; // Por defecto fecha en formato 12 horas (am/pm)

    @Override
    public int doEndTag() throws JspException {
        Calendar fechaHoraActual = new GregorianCalendar();
        int hora = 0, minutos = 0;
        String fechaHora, ampm = "";
        JspWriter out = pageContext.getOut();

        try {
            if (atrib1 == 12) {
                hora = fechaHoraActual.get(Calendar.HOUR); // Hora reloj 12 h
                if (hora == 0) hora = 12;
                System.out.println(" > Etiqueta fecha invocada con formato 12 h. (" + hora + ")");
                if (fechaHoraActual.get(Calendar.AM_PM) == Calendar.AM){ // Si es antes de mediodía
                    ampm = " AM ";
                }else {
                    ampm = " PM ";
                }
            } else if (atrib1 == 24) {                
                hora = fechaHoraActual.get(Calendar.HOUR_OF_DAY); // Hora reloj 24 h.
                ampm = "";
                System.out.println(" > Etiqueta fecha invocada con formato 24 h. (" + hora + ")");
            }
            minutos = fechaHoraActual.get(Calendar.MINUTE);
            fechaHora = fechaHoraActual.get(Calendar.DAY_OF_MONTH)
                    + "-" + (fechaHoraActual.get(Calendar.MONTH) + 1) + "-"
                    + fechaHoraActual.get(Calendar.YEAR);
            out.println("Hora actual: " + hora + ":" + minutos + ampm);
            out.print("Fecha actual: " + fechaHora);

        } catch (IOException e) {
            try {
                out.println("Error en etiqueta: " + e.getMessage());
            } catch (IOException ioe) {}
        }
        return super.doEndTag();
    }

    // Método para recibir el atributo procedente de la página JSP. Coincide en nombre
    public void setAtrib1(int atrib1) {
        this.atrib1 = atrib1;
    }
}
