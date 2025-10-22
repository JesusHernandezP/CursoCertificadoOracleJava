<%-- 
    Document   : etiquetaCuerpoRep
    Created on : Jul 18, 2016, 13:40:43 PM
    Author     : Pedro Andrés Díaz Gómez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/taglib" prefix="facil" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>etiquetaCuerpoRep</title>
    </head>
    <body>
        <h2>Etiquetas personalizadas</h2>
        <p>
            Imprimiendo con la etiqueta personalizada &quot;cuerpoRepTag&quot;:
        </p>
        <strong>
            &lt;facil:cuerpoRepTag veces='10'&gt;Repetir 10 veces&lt;/facil:cuerpoRepTag&gt;<br/>
        </strong>
        <facil:cuerpoRepTag veces="10">Repetir 10 veces</facil:cuerpoRepTag><br/>
        <p>
            Se trata de una etiqueta con cuerpo (body) y atributos.<br/>
            El resultado del texto superior ha sido generado por una clase java CuerpoRepTag.java,<br/>
            que extiende de BodyTagSupport y su descriptor de librer&iacute;a de etiquetas <br/>
            es (taglib.tld) y esta p&aacute;gina etiquetaCuerpoRep.jsp
        </p>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>