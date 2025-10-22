package com.etiq;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MiFechaTag extends TagSupport{
	private static final long serialVersionUID = -8044196559005861518L;
	
	private int atrib1 = 12;

        @Override
	public int doEndTag() throws JspException {
		Calendar fechaHoraActual = new GregorianCalendar();
		int hora = 0, minutos = 0;
		String fechaHora;
		JspWriter out = pageContext.getOut();
		
		try {
			System.out.println(" > Etiqueta fecha invocada...");
			if (atrib1 == 12){
				hora = fechaHoraActual.get(Calendar.HOUR); // Hora reloj 12 h
			}else{
				hora = fechaHoraActual.get(Calendar.HOUR_OF_DAY) ;
			}
			minutos = fechaHoraActual.get(Calendar.MINUTE);
			fechaHora = fechaHoraActual.get(Calendar.DAY_OF_MONTH) +
                                "-" + fechaHoraActual.get(Calendar.MONTH) + "-" +
                                fechaHoraActual.get(Calendar.YEAR);
			out.println("Hora actual: " + hora + ":" + minutos);
			out.print("Fecha actual: " + fechaHora);
			
		}catch(Exception e){
			try {
				out.println("Error en etiqueta: " + e.getMessage());
			}
			catch(IOException ioe){}
		}
		return super.doEndTag();
	}
	// Método para recibir el atributo procedente de la página JSP. Coincide en nombre
	public void setAtrib1(int atrib1) {
		this.atrib1 = atrib1;
	}
}