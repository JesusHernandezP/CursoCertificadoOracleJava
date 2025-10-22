<%@page contentType="text/html" isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="es">
    <head>
        <title>jspError.jsp</title>
    </head>
    <body bgcolor="#dd8877">
        <h2>Ejemplo 4: jspError.jsp</h2>
        <h1>Error interno</h1>
        <hr></hr>
        <h2>Contacte con el administrador para los detalles</h2>
        <hr></hr>
        <br/>
        <p/>
        <p/>
        <font size="6">
        <p>
            La excepción ocurrida fue: <%=exception.getMessage()%> <br/>
            URL origen: <c:out value="${requestScope['javax.servlet.error.request_uri']}"/>
        </p>
        Mensaje ampliado: <% out.print(exception.toString());%>
        </font>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>