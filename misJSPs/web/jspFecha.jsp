<html>
    <head><title>jspFecha.jsp</title></head>
    <body>
        <h2>Ejemplo 2 JSP: jspFecha.jsp</h2>
        <%-- Expresión que muestra la fecha actual --%>
        Esta jsp incluye la fecha actual del servidor: 
        <%= new java.util.Date() %>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>