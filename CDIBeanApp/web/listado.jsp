<%-- 
    Document   : listado
    Created on : 24-oct-2025, 18:29:09
    Author     : jahp8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Listado de libros</title> 
    </head> 
    <body> 
        <h2>Listado de libros</h2> 
        <c:forEach items="${lib.libros}" var="elem"> 
            <c:out value="${elem.key}"/> 
            <c:out value=" – " /> 
            <c:out value="${elem.value}"/> 
            <br> 
        </c:forEach> 
        <a href="index.html">Volver a la página inicial</a> 
    </body> 
</html>
