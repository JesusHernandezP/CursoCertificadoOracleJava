<!DOCTYPE html>
<%-- UsoBean.jsp
  Ejemplo para mostrar el uso de la acción jsp:useBean. Esta página utiliza
  esta acción para generar el mensaje de bienvenida y despedida en base a la
  propiedad "mensaje" del JavaBean UsoBean.java
--%>
<html>
    <head>
        <title>Ejemplo 8 JSP: Acción jsp:useBean</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body bgcolor="#FFFF99">
        <%-- indicamos que se quiere utilizar una instancia del objeto UsoBean, al
          que se va a referenciar posteriormente como miBean --%>
        <jsp:useBean id="miBean" scope="page" class="uso.bean.UsoBean" />
        <h2>Ejemplo 8 JSP, de la acción <i>jsp:useBean</i></h2>
        &lt;jsp:useBean id="miBean" scope="page" class="usobean.UsoBean"/&gt;
        <p>Mensaje inicial en el Bean: (&lt;%= miBean.getMensaje()%&gt;)<br>
            <%-- se obtiene a partir del valor actual de la propiedad del bean,
              invocando al método get() de la propiedad --%>
            <strong><%= miBean.getMensaje()%></strong>
        <p>Mensaje final puesto en el Bean: (&lt;% miBean.setMensaje("Hoy es martes");%&gt;)<br>
            <%-- se fija el nuevo valor de la propiedad, para asignarle el valor de
              la despedida a través del método set() de la propiedad, y se presenta
              de nuevo usando el método get() de la propiedad --%>
            <%miBean.setMensaje("Hoy es jueves");%>
            <strong><%= miBean.getMensaje()%></strong>
            <br/><%= miBean.mensajeActual()%> (&lt;%= miBean.mensajeActual()%&gt;)<br/>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>