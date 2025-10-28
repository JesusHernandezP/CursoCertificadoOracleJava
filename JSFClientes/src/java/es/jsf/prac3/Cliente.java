package es.jsf.prac3;


public class Cliente {
    private String nombre;
    private String telefono;
    private double importe;
    
    public Cliente(){}

    public Cliente(String nombre, String telefono, double importe) {
        this.nombre= nombre;
        this.telefono= telefono;
        this.importe= importe;
        
        
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

    @Override
    public String toString() {
        return "Cliente{" + ", " + nombre + ", " + telefono + ", " + importe ;
    }
    
    
    
    
}
