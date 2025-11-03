package es.emple;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class EjerJAXBMain {

    public static void main(String[] args) throws JAXBException {
        File fichero = new File("src/Empleados2.xml");
        // Objeto que vamos a cargar con los datos del documento Empleados2.xml:
        Empleado empleado = new Empleado();
        JAXBContext jaxb = JAXBContext.newInstance(Empleado.class);

        Unmarshaller u = jaxb.createUnmarshaller();
        empleado = (Empleado) u.unmarshal(fichero);
        System.out.println("Objeto Empleado con los datos procedentes del xml: ");
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Apellidos: " + empleado.getApellidos());
        System.out.println("Sueldo:" + empleado.getSueldo());

        empleado = new Empleado();
        empleado.setNombre("Miguel Ángel");
        empleado.setApellidos("Hernández");
        empleado.setSueldo(2000.50);

        // Realizamos "Marshalling" a un nuevo documento xml con los cambios

        jaxb = JAXBContext.newInstance(Empleado.class);
        fichero = new File("src/Empleados3.xml");
        Marshaller m = jaxb.createMarshaller();
        m.marshal(empleado, fichero);
        
    }
}
   