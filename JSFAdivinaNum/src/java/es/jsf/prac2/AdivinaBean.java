package es.jsf.prac2;

import java.io.Serializable;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Named; // Atención a las nuevas anotaciones
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@Named(value = "adivinaBean") // Atención a las nuevas anotaciones
public class AdivinaBean implements Serializable {

    private int respuesta; // Número que hay que adivinar, obtenido en reinicio()
    private int adivina; // Número indicado por el usuario

    public AdivinaBean() {
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getAdivina() {
        return adivina;
    }

    public void setAdivina(int adivina) {
        this.adivina = adivina;
    }

    public void compruebaNum() {
        String mensaje = "";
        if (adivina == respuesta) {
            mensaje = "Enhorabuena, has acertado el número";
            
            reinicio();
            
        } else if (adivina > respuesta) {
            mensaje = "Demasiado grande";
        } else if (adivina < respuesta) {
            mensaje = "Demasiado pequeño";
        }
        FacesContext.getCurrentInstance().addMessage("null",
                new FacesMessage(mensaje)); // Mensaje nuevo al navegador
    }

    @PostConstruct
    public void reinicio() {
        adivina = 0; // Valor que se mostrará al usuario al arrancar por ciclo de vida
        respuesta = new Random().nextInt(100);
        System.out.println(" > El número es: " + respuesta);
    }
}
