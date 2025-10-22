<%-- 
    Document   : index.jsp
    Created on : Jul 18, 2016, 09:06:23 AM
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplos misEtiq</title>
        <link rel="stylesheet" href="estilos.css" type="text/css"/>
    </head>
    <body class="fondo">
        <div><h2>
            <img src="images/glassfish.jpg" border="0" alt="glassfish"/>
            Ejemplos de mis Etiquetas
            <img src="images/javaEE.png" border="0" alt="javaEE"/>
            </h2></div>
        <hr/>
        <ol>
            <li><a href="etiquetaHM.jsp">etiquetaHM.jsp</a>&Tab;Ejemplo m&iacute;nimo de etiqueta personalizada sin atributos ni cuerpo</li>
            <li><a href="etiquetaFecha.jsp">etiquetaFecha.jsp</a>&Tab;Ejemplo que imprime fecha con formato seg&uacute;n un par&aacute;metro</li>
            <li><a href="etiquetaCuerpo.jsp">etiquetaCuerpo.jsp</a>&Tab;Etiqueta con cuerpo (body)</li>
            <li><a href="etiquetaCuerpoRep.jsp">etiquetaCuerpoRep.jsp</a>&Tab;Etiqueta con cuerpo (body) y atributos</li>
        </ol>
        <hr/>
    </body>
</html>
