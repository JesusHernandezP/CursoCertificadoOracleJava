<html>
    <head><title>forward3.jsp</title></head>
    <body bgcolor="#ccbbaa">
        <h2>Ejemplo 7 JSP: Uso de forward (3)</h2>
        <% int num = Integer.parseInt(request.getParameter("parametro1"));%>
        <!-- Texto final de la p�gina que se env�a al navegador cliente -->
        <p/>Texto de la p�gina HTML <strong>forward3.jsp</strong> presentado a trav�s de la petici�n
        original de la p�gina <i>forward1.jsp</i>, pasando por la petici�n intermedia
        de la p�gina <i>forward2.jsp</i><br/>
        El valor del par�metro enviado desde <strong>forward2.jsp</strong> es:<%= num%>
        <br/>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>