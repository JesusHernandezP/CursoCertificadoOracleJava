<%-- 
    Document   : tagsJSTL
    Created on : Jun 28, 2016, 5:43:58 PM
    Author     : Pedro
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>tagsJSTL.jsp</title>
    </head>
    <body>
        <h2>tagsJSTL.jsp</h2>
        Ejemplos de algunas etiquetas de JSTL
        <p>Valor del tag &lt;c:url&gt; para el fichero index.jsp:</p>
        <c:url value="/index.jsp"/>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
        <c:import url="texto.txt"/> <%-- Pega un texto aquí mismo --%>
        <%
            java.util.Map map = new java.util.HashMap();
            request.setAttribute("map", map); 
            map.put("a","b");
            map.put("b","c");
            map.put("c","d"); 
        %>
        <br>
        1 ${map.c}<br>
        2 ${map["c"]}<br>
        3 ${map.a}<br>
        4 ${map[map.b]}<br>
    </body>
</html>
