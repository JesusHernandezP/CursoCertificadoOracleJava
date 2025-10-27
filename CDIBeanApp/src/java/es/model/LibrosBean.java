package es.model; 
 
import java.io.Serializable; 
import java.util.HashMap; 
import java.util.Map; 
 
import javax.enterprise.context.SessionScoped; 
import javax.inject.Named; 
 

@Named("lib") 
@SessionScoped 
public class LibrosBean implements Serializable { 
    private final Map<String, String> libros; 
 
    public LibrosBean() { 
        System.out.println("> Constructor de LibrosBean llamado"); 
        libros = new HashMap<>(); 
    } 
    public void inserta(String titulo, String autor) { 
        this.libros.put(titulo, autor); 
 System.out.println("> Libros existentes: " + libros.size()); 
    }   
    public Map<String, String> getLibros() { 
        return libros; 
    } 
} 
 
 
