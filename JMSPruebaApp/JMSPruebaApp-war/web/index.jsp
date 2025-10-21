<%@page import="javax.jms.MessageProducer"%>
<%@page import="javax.jms.Queue"%>
<%@page import="javax.jms.Session"%>
<%@page import="javax.jms.Connection"%>
<%@page import="javax.jms.QueueConnectionFactory"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <title>index.jsp</title>
 </head>
 <h2>Prueba JMS</h2><br/>
 <hr>
 Este JSP inserta un mensaje de texto en la cola "jms/QueueTest"
 El éxito de la operación se indica a continuación.
 Después sólo queda invocar a un programa consumidor de mensajes.
 <p>Prueba a actualizar la página para enviar un nuevo mensaje...</p>
 <p>Observa a la vez la consola de mensajes del servidor de aplics.</p>
 <hr>
 <body>
<%! private int contador = 0; %>
 <%
 try{
 InitialContext context = new InitialContext();
 QueueConnectionFactory cF =
(QueueConnectionFactory)context.lookup("jms/QueueFactoryTest");
 Queue queue = (Queue)context.lookup("jms/QueueTest");
 Connection con = cF.createConnection();
 Session sesion = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
 MessageProducer messProd = sesion.createProducer(queue);
 contador++;
 messProd.send(sesion.createTextMessage("Mensaje de Prueba " + contador));
 messProd.close();
 sesion.close();
 con.close();
 out.println("El mensaje " + contador + " se envió correctamente");
 }catch(Exception e){
 out.println("No fue posible enviar el mensaje: " + e.getMessage());
 }
 %>
 </body>
</html>