package es.ejb.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue
            = "jms/QueueTest")
    ,
 @ActivationConfigProperty(propertyName = "destinationType", propertyValue
            = "javax.jms.Queue")
})
public class TestMessageBean implements MessageListener {

    public TestMessageBean() {
    } // Constructor sin parámetros obligatorio

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(" > Recibido un mensaje de texto: " + ((TextMessage) message).getText());
        } catch (JMSException exc) {
            System.out.println(" > Error leyendo un mensaje: " + exc.getMessage());
        }
    }
}
