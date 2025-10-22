<%-- 
    Document   : index.jsp
    Created on : Jun 28, 2016, 2:06:23 PM
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplos mis Filtros</title>
        <link rel="stylesheet" href="estilos.css" type="text/css"/>
    </head>
    <body class="fondo">
        <div><h2>
                <img src="images/glassfish.jpg" border="0" alt="glassfish"/>
                Ejemplos de mis Filtros
                <img src="images/javaEE.png" border="0" alt="javaEE"/>
        </h2></div>
        <hr/>
        <ol>
            <li><a href="BasicServlet?nom=Pedro&ape=Diaz">BasicServlet</a>&Tab;Procesamiento mínimo de Filtros</li>
            <li><a href="AuditServlet">AuditServlet</a>&Tab;Filtro de auditoría con contador</li>
        </ol>
        <hr/>
    </body>
</html>
