package es.jsf.prac3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "clienteBean")
public class ClienteBean implements Serializable {

    private static int contador;
    private String nombre;
    private String telefono;
    private double importe;
    private String mensaje;
    
// Estructura de datos Java para almacenar los datos en memoria...
    private List<Cliente> listaCliente;

    public ClienteBean() {
        System.out.println("Constructor de clienteBean");
    } // Constructor por defecto necesario

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        ClienteBean.contador = contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return this.mensaje;
    }
    

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    

    public String doGuardar() {
// return null indica volver a la página anterior
        Cliente cliente = new Cliente(nombre, telefono, importe);
        listaCliente.add(cliente);
        contador++;
        System.out.printf("> Añadido el %2d cliente", contador);
        limpiaFormulario();
        setMensaje ("Se ha añadido un nuevo usario");
        return null;

    }

    public String doVer() {
// Deberá devolver un String con el nombre de la página
// getters y setters, etc.
// Lo que necesites además de lo dicho, a introducir desde aquí}
        return "VerTodos";

    }

    private void limpiaFormulario() {
        setMensaje("");
        nombre = "";
        telefono = "";
        importe = 0.0;

    }
    @PostConstruct
    public void iniciarApp(){
        if(contador != 0 ){
            setMensaje("Lista destruida");
        }else{
            setMensaje("Se ha creado la lista");
        }
        listaCliente = new ArrayList<>();
        System.out.println("mensaje");
        contador = 0;
    }
    
    @PreDestroy
    public void finalizarApp(){
        System.out.println("Se ha destruido el bean " + ClienteBean.class.getSimpleName());
    }

}
