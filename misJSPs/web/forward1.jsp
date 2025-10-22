<html>
    <head><title>forward1.jsp</title></head>
    <body bgcolor="#aabbcc">
        <h2>Ejemplo 7 JSP: Uso de forward (1)</h2>
        <!-- Primero solicitamos la página forward2.jsp -->
        <p>Vamos a realizar un desvío de la petici&oacute;n recibida por esta página
            hacia otra página jsp <b>forward2.jsp</b><br>
            <%-- El texto anterior no aparecerá en la página que se envíe al navegador
            porque todo ese texto estará en el buffer y se perderá en el momento en que
            la petición sea desviada hacia la nueva página JSP --%>

            <jsp:forward page="forward2.jsp"/>
            <%-- El texto siguiente nunca aparecerá en el navegador porque la petición
            ha sido desviada completamente hacia la otra página JSP --%>
        <p>Este texto de la página <b>forward2.jsp</b> tampoco se mostrará nunca
    </body>
</html>