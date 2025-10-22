<%-- 
    Document   : index.jsp
    Created on : Jun 28, 2016, 2:06:23 PM
    Author     : Pedro Andrés Díaz Gómez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplos mis JSPs</title>
        <link rel="stylesheet" href="estilos.css" type="text/css"/>
    </head>
    <body class="fondo">
        <div><h2>
            <img src="images/glassfish.jpg" border="0" alt="glassfish"/>
            Ejemplos de mis JSPs
            <img src="images/javaEE.png" border="0" alt="javaEE"/>
            </h2></div>
        <hr/>
        <ol>
            <li><a href="holamundo.jsp">holamundo.jsp</a>&Tab;Ejemplo m&iacute;nimo de JSP</li>
            <li><a href="jspFecha.jsp">jspFecha.jsp</a>&Tab;Fecha actual</li>
            <li><a href="FormatFecha.jsp">FormatFecha.jsp</a>&Tab;Formateo de fechas</li>
            <li><a href="bucle.jsp">bucle.jsp</a>&Tab;Bucles con JSP</li>
            <li><a href="PagConError.jsp">PagConError.jsp</a>&Tab;Tratamiento de errores</li>
            <li><a href="inclujsp.jsp">inclujsp.jsp</a>&Tab;Inclusi&oacute;n de documentos</li>
            <li><a href="forward1.jsp">forward1.jsp</a>&Tab;Transferencia de control</li>
            <li><a href="UsoBean.jsp">UsoBean.jsp</a>&Tab;Uso de Java Beans (estilo 1)</li>
            <li><a href="Property.jsp">Property.jsp</a>&Tab;Uso de Java Beans (estilo 2)</li>
        </ol>
        <h3>Ejemplos con JSTL y LE</h3>
        <ol>
            <li><a href="ejemploJSTL.jsp?clave=secreto">ejemploJSTL.jsp</a>&Tab;Declaraciones b&aacute;sicas</li>
            <li><a href="tagsJSTL.jsp">tagsJSTL.jsp</a>&Tab;Ejemplos de algunos Tags de JSTL</li>
            <li><a href="cuentaJSTL.jsp?parNombre=Pedro">cuentaJSTL.jsp</a>&Tab;Lectura de parámetros</li>
            <li><a href="bucletablaJstl.jsp?atrCuenta=10">bucletabla.jsp</a>&Tab;Lectura de parámetros con bucle</li>
            <li><a href="bucleSelectJstl.jsp">bucleSelectJstl.jsp</a>&Tab;Carga de datos desde un ArrayList a un &lt;select&gt;</li>
        </ol>
        <hr/>
    </body>
</html>
