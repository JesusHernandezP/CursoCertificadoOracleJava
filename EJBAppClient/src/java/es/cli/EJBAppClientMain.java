package es.cli;

import es.ejb.MySessionBeanRemote;
import javax.ejb.EJB;

public class EJBAppClientMain {

    @EJB
    private static MySessionBeanRemote mySessionBean;

    public static void main(String[] args) {
        
        System.out.println(mySessionBean.getResult());
        
    }
    
}
