<!DOCTYPE HTML >
<%-- Property.jsp --%>
<html>
    <head>
        <title>Ejemplo 9 JSP: Acci&oacute;n jsp:setProperty</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    </head>

    <body bgcolor="#ffff99">
        <%-- Indicamos que se quiere utilizar una instancia del objeto UsoBean.java
          al que se va a referenciar posteriormente como "miBean" --%>
        <jsp:useBean id="miBean" scope="page" class="uso.bean.UsoBean" />

        <h2>Ejemplo 9 JSP: Acci�n <i>jsp:set/get/Property</i></h2>
        <p>Mensaje inicial en el Bean:<br><b>
                <%-- se obtiene a partir del valor actual de la propiedad del bean, utilizando la acci�n jsp:getProperty --%>
                <jsp:getProperty name="miBean" property="mensaje" />
            </b><p>Mensaje final puesto en el Bean:<br>
            <%-- Se establece el nuevo valor de la propiedad, para asignarle el valor de
              la despedida a trav�s de la acci�n jsp:setProperty y se muestra de nuevo
              usando la acci�n jsp:getProperty --%>
            <jsp:setProperty name="miBean" property="mensaje" value="Hoy es martes 21 de Marzo" />
            <strong>
                <jsp:getProperty name="miBean" property="mensaje" />
            </strong>
            <br><br>�Te ha gustado el resultado?
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>