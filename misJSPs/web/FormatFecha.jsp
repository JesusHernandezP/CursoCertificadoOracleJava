<%@page contentType="text/html" import="java.util.Date,java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
    <head>
        <title>FormatFecha.jsp</title>
    </head>
    <body bgcolor="#bbccaa">
        <h2>Ejemplo 3 JSP: FormatFecha.jsp</h2>
        <h3>Formateo de Fechas en Java</h3>
        <%-- Comienza el Scriptlet --%>
        <%
            Date ahora = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd ' de ' MMMM ' de ' yyyy HH:mm:ss");
        %>
        <h3>Fecha original: <%=ahora%></h3><br/>
        <h3>Fecha formateada: <%=formato.format(ahora)%></h3>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>