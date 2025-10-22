<%-- 
    Document   : etiquetaFecha.jsp
    Created on : Jul 18, 2016, 9:30:02 AM
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/taglib" prefix="facil" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>etiquetaFecha</title>
    </head>
    <body>
        <h2>Etiquetas personalizadas</h2>
        <p>
            Imprimiendo con la etiqueta personalizada &quot;miFecha&quot;:
        </p>
        <strong>
            &lt;facil:miFecha atrib1="24"&gt;&lt;/facil:miFecha&gt;<br>
        </strong>
        <br/>
        <facil:miFecha/><br/>
        La fecha en 12 horas es: <facil:miFecha/><br>
        La fecha en 24 horas es: <facil:miFecha atrib1="24"/><hr>
        <p>
            Se trata de una etiqueta sin cuerpo (body) y con un atributo (atrib1) como ejemplo de uso<br>
            de un parámetro para indicar el formato de la hora (12 ó; 24 horas.<br>
            Se usa el descriptor de la librería de etiquetas (taglib.tld) y esta página etiquetaFecha.jsp
        </p>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>