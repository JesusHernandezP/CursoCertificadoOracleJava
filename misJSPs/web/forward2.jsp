<html>
    <head><title>forward2.jsp</title></head>
    <body bgcolor="#bbaacc">
        <h2>Uso de forward (2)</h2>
        <!-- Solicitamos la 3. p�gina -->
        <p/>Vamos a realizar un desv�o de la petici�n recibido por esta p�gina
        hacia la p�gina html <strong>forward3.html</strong><br/>
        <%-- El texto anterior no aparecer� en la p�gina que se env�e al navegador
        porque todo ese texto estar� en el buffer y se perder� en el momento en que
        la petici�n sea desviada hacia la nueva p�gina HTML o JSP --%>
        <jsp:forward page="forward3.jsp">
            <jsp:param name="parametro1" value="4"/>
        </jsp:forward>
        <%-- El texto siguiente nunca aparecer� en el navegador porque la petici�n
        ha sido desviada completamente hacia la otra p�gina HTML --%>
        <p>Este texto de la p�gina <b>forward2.jsp</b> tampoco se mostrar� nunca
    </body>
</html>