<html>
    <head><title>forward2.jsp</title></head>
    <body bgcolor="#bbaacc">
        <h2>Uso de forward (2)</h2>
        <!-- Solicitamos la 3. página -->
        <p/>Vamos a realizar un desvío de la petición recibido por esta página
        hacia la página html <strong>forward3.html</strong><br/>
        <%-- El texto anterior no aparecerá en la página que se envíe al navegador
        porque todo ese texto estará en el buffer y se perderá en el momento en que
        la petición sea desviada hacia la nueva página HTML o JSP --%>
        <jsp:forward page="forward3.jsp">
            <jsp:param name="parametro1" value="4"/>
        </jsp:forward>
        <%-- El texto siguiente nunca aparecerá en el navegador porque la petición
        ha sido desviada completamente hacia la otra página HTML --%>
        <p>Este texto de la página <b>forward2.jsp</b> tampoco se mostrará nunca
    </body>
</html>