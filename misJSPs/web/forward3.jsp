<html>
    <head><title>forward3.jsp</title></head>
    <body bgcolor="#ccbbaa">
        <h2>Ejemplo 7 JSP: Uso de forward (3)</h2>
        <% int num = Integer.parseInt(request.getParameter("parametro1"));%>
        <!-- Texto final de la página que se envía al navegador cliente -->
        <p/>Texto de la página HTML <strong>forward3.jsp</strong> presentado a través de la petición
        original de la página <i>forward1.jsp</i>, pasando por la petición intermedia
        de la página <i>forward2.jsp</i><br/>
        El valor del parámetro enviado desde <strong>forward2.jsp</strong> es:<%= num%>
        <br/>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>