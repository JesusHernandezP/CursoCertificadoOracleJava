<!DOCTYPE html>
<html lang="es">
    <head>
        <title>bucle.jsp</title>
    </head>

    <body bgcolor="#99FF20">
        <!-- Pagina hecha con JSP -->
        <%-- Comentario oculto de JSP --%>
        <h2>Ejemplo 4 JSP: bucle.jsp</h2>
        <h1>Saludos</h1>
        <%! private int i = 0; %>
        <%
            for (; i <= 7; i++) {
        %>
                <font size=<%= i%>>&iexcl;Hola Mundo!<br></font>
        <%}%>
        La i vale: <%= i%>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>