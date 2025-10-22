<%-- 
    Document   : cuentaJSTL
    Created on : 17-nov-2015, 17:15:21
    Author     : Profesortarde
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta JSTL</title>
    </head>
    <body>
        <h1>Cuenta JSTL</h1>
        <!-- Incrementamos un contador de visitas a la página -->
        <c:set var="atrCuenta" scope="application" value="${atrCuenta + 1}"/>
        <h2>Demostración de seguimiento a nivel de aplicación</h2>
        Hola ${param.parNombre}, has visitado esta página
        ${atrCuenta} ${atrCuenta > 1 ? " veces." : " vez."}
    </body>
    <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
</html>
