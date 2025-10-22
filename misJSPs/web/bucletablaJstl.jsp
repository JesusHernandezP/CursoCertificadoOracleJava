<%-- 
    Document   : bucleJstl
    Created on : 17-nov-2015, 18:07:45
    Author     : Pedro Andrés Díaz Gómez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bucletablaJstl.css">
        <title>BucleTablaJSTL</title>
    </head>
    <body>
        <h2>BucleTablaJSTL</h2>
        <table border="1">
            <c:forEach var="elem" begin="1" end="${param.atrCuenta}">
                <tr><td>${elem}</td><td>${elem %2 == 0 ? "par":"impar"}</td></tr>
            </c:forEach>    
        </table>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>
