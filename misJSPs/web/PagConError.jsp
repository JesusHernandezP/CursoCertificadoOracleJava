<!DOCTYPE html>
<%@page errorPage="/jspError.jsp"%>
<html lang="es">
    <head>
        <%-- No se gestionan errores de incluir otros archivos... ---%>
        <title>PagConError.jsp</title>
    </head>

    <body bgcolor="#ee9988">
       <h2>Ejemplo 5: PagConError.jsp</h2>
       <h3>P�gina con errores y su gesti�n con JSP</h3>
        <%
            int x = 10;
            int y = 5;
            out.write("La divisi�n entre 10 y 0 da: " + (x / y));
        %>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>