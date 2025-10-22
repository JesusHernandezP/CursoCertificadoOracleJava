<html>
    <head><title>forward1.jsp</title></head>
    <body bgcolor="#aabbcc">
        <h2>Ejemplo 7 JSP: Uso de forward (1)</h2>
        <!-- Primero solicitamos la p�gina forward2.jsp -->
        <p>Vamos a realizar un desv�o de la petici&oacute;n recibida por esta p�gina
            hacia otra p�gina jsp <b>forward2.jsp</b><br>
            <%-- El texto anterior no aparecer� en la p�gina que se env�e al navegador
            porque todo ese texto estar� en el buffer y se perder� en el momento en que
            la petici�n sea desviada hacia la nueva p�gina JSP --%>

            <jsp:forward page="forward2.jsp"/>
            <%-- El texto siguiente nunca aparecer� en el navegador porque la petici�n
            ha sido desviada completamente hacia la otra p�gina JSP --%>
        <p>Este texto de la p�gina <b>forward2.jsp</b> tampoco se mostrar� nunca
    </body>
</html>