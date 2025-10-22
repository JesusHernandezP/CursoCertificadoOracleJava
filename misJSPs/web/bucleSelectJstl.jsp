<%-- 
    Document   : bucleSelectJstl
    Created on : Jun 30, 2016, 4:54:06 PM
    Author     : Pedro
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>bucleSelectJstl.jsp</title>
    </head>
    <body>
        <h2>Ciudades disponibles</h2>
        <%!java.util.ArrayList cities = new java.util.ArrayList();%>
        <%
            cities = new java.util.ArrayList();
            cities.add("MAD");
            cities.add("BCN");
            cities.add("SEV");
            cities.add("ALC");
            cities.add("MLG");
            cities.add("MUR");
            cities.add("COR");
            cities.add("ZAR");
            pageContext.setAttribute("cities", cities);
        %>
        <c:forEach var="ciud" items="${cities}">
            <c:out value="${ciud}, "/>
        </c:forEach>
        <p/>
        <select name="Ciudades">
            <c:forEach var="ciud" items="${cities}" >
                <option value=${ciud}>${ciud}&nbsp;</option>
            </c:forEach>
        </select>
        <p>
        Número de ciudades: 
        <%= cities.size() %>
        </p>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>
