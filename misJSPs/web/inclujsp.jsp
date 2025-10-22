<%-- 
    Document   : inclujsp.jsp Página JSP para detallar el uso de inclusión
    Created on : Jun 30, 2016, 5:13:02 PM
    Author     : Pedro Andrés Díaz Gómez
--%>
<!DOCTYPE html>
<jsp:directive.page pageEncoding="UTF-8"/>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclusión de documentos con JSP</title>
    </head>
    <body>
        <h2>Ejemplo 6 JSP: directiva <i>include</i></h2>
        - Vamos a incluir con la directiva include un archivo HTML:
        &lt;%@ include file="htmMensa.html" %&gt;<br>
        <%-- Incluimos 1º el archivo html que muestra mensaje en otro color --%>
        <%--@include file="htmMensa.html" (sintaxis jsp) --%>
        <jsp:directive.include file="htmMensa.html" /><%-- (sintaxis xml) --%>
        <p>
            Cuerpo de la página original<br>
            Texto 1<br>
            Texto 2<br>
            etc... <br>
        </p>
        - Ahora vamos a incluir una página JSP con la acción jsp:include: 
        &lt;jsp:include page="piepag.jsp"&gt;<br>
        <%-- Ahora el jsp --%>
        <%--<jsp:include file="htmMensa.html" (sintaxis jsp)/> --%>
        <jsp:include page="piepag.jsp"/>
        <br>- Fin. Esto es del JSP original<br>
        <p><a href="index.jsp">Volver a la página inicial</a></p>
    </body>
</html>