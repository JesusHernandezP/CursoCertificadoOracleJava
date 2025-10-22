<%-- 
    Document   : etiquetaHM.jsp
    Created on : 15-jul-2016, 21:42:08
    Author     : Pete
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/taglib" prefix="facil" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>etiquetaHM</title>
    </head>
    <body>
        <h2>Etiquetas personalizadas</h2>
        <p>
            Imprimiendo con la etiqueta personalizada &quot;holamundo&quot;:
        </p>
        <strong>
            &lt;facil:holamundo&gt;&lt;/facil:holamundo&gt;<br/>
        </strong>
            <facil:holamundo></facil:holamundo><br/>
        <p>
            Se trata de una etiqueta sin cuerpo (body) y sin atributos como primer ejemplo simple.<br/>
            El resultado del texto superior ha sido generado por una clase java HolaMundoTag.java,<br/>
            el descriptor de la librer&iacute;a de etiquetas (taglib.tld) y esta p&aacute;gina etiqueta.jsp
        <facil:holamundo/><!-- Al no tener cuerpo, puedo invocarla así -->
        </p>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>
