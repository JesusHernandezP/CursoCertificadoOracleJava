<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>holamundo.jsp</title>
        <link rel="stylesheet" href="holamundo.css">
    </head>
    
        <!--Pagina hecha con JSP -->
        <%!private int x = 7;%>
        <%--Comentario oculto de JSP --%>
        <h2>Ejemplo 1 JSP: holamundo.jsp</h2>
        <!-- Esto es un comentario HTML (se muestra en el cliente) -->
        <%-- Esto es un comentario JSP (no aparece en el cliente) --%>
        <% String nombre = "Juan";%>
        <%-- Imprimimos como en HTML: --%>
        Hola <%= nombre%>, soy una página JSP.<br>
        <%-- Imprimimos por medio del objeto implicito "out" --%>
        <% out.println("Hola " + nombre + ", soy una página JSP."); %>
        <h3>Repaso de los elementos presentes en JSP:</h3>
        <ul>
            <li>Comentarios: &lt;%--Comentario de JSP (oculto en el navegador cliente)--%&gt;</li>
            <li>Declaraciones: &lt;%! private int x = 10;%&gt;</li>
            <li>Expresiones: &lt;%= x%&gt;</li>
            <li>Directivas: &lt;%@page import="java.util.List"%&gt;</li>
            <li>Acciones (elementos estándar): &lt;jsp:useBean id="miClase" class="com.jsp.MiClase"/&gt;</li>
            <li>Expresión L.E.: $&lbrace;expresión&rcub;</li>
            <li>Objetos implícitos: request, response, pageContext, session, application, out, config, page, exception</li>
            <li>Objetos implícitos EL: Ámbitos:</li>
            <ul><li>requestScope, pageScope, sessionScope, applicationScope</li></ul>
            <li>Objetos implícitos adicionales EL:</li>
            <ul><li>initParam, param, paramValues, header, headerValues, cookie</li></ul>
        </ul>
        <% int[] nums = {42, 420, 4200};
            request.setAttribute("foo", nums);
        %>
        <br>Lenguaje de Expresión: ${5 + 3 < 6}
        <br>Lenguaje de Expresión: ${requestScope.foo[2] == 4200}
        <br>Lenguaje de Expresión: ${10 div 2}
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>     
    
