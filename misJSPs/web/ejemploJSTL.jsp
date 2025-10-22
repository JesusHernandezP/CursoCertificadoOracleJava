<%-- 
    Document   : ejemploJSTL
    Created on : 16-nov-2015, 20:53:17
    Author     : Pedro Andrés Díaz Gómez
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>ejemploJSTL.jsp</h2>
        <h3>Leyendo parámetros de contexto</h3>
        <c:out value = "Forma 1: ${initParam.titlestr}"/>
            &dollar;{initParam.titlestr}<br/>
        <c:out value = "Forma 2: ${initParam['titlestr']}"/>
            &dollar;{initParam["titlestr"]}<br/>
        <c:out value="Números: 1+2+3"/><br/>
        <c:out value="Números: ${1+2+3}"/><br/>
        <c:out value="Clave: ${param.clave}"/><br/>
        <c:set var="varAplicacion" scope="application">
            Esta información se guarda en la aplicación
        </c:set>
        <c:out value="${varAplicacion}"/>
        <!-- ${varAplicacion} -->
        <%-- IMPORTANTE: METER LA CLAVE PARA QUE NO CARGUE LA OTRA PÁGINA --%>
        <c:if test="${param.clave != 'secreto'}">
            ${clave}
            <c:redirect url="bucle.jsp"/>
        </c:if>
        <c:set var="pageTit1">
            Página de Duke
        </c:set>
        <c:set var="pageTit2" value="Página de Duke"></c:set>
        <br/>Dos variables:
        <br/>${pageTit1}
        <br/>${pageTit2}
        <%-- Probando scriptlets con la sintaxis xml: --%>
        <%
            for(int i=0; i<5; i++)
            {
                out.println("World");
            }
        %>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>
