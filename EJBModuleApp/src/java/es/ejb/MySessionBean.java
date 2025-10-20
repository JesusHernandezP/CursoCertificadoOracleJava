package es.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class MySessionBean implements MySessionBeanRemote {
    @PostConstruct
    public void init(){
        System.out.println("Se ha invocado el Ejb MySessionBean");
    }

    @Override
    public String getResult() {
        
        return "Respuesta REMOTA desde un EJB de sesión sin estado";

                
    }
    
    @PreDestroy 
    
    public void ended(){
        System.out.println("El Bean MySessionbean se ha destruido");
    }

   
    
    }

    

    

