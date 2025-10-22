<%-- 
    Document   : etiquetaCuerpo.jsp
    Created on : Jul 18, 2016, 12:59:43 PM
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/taglib" prefix="facil" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>etiquetaCuerpo</title>
    </head>
    <body>
        <h2>Etiquetas personalizadas</h2>
        <p>
            Imprimiendo con la etiqueta personalizada &quot;etiquetaCuerpo&quot;:
        </p>
        <strong>
            &lt;facil:cuerpoTag&gt;etiqueta con cuerpo&lt;/facil:cuerpoTag&gt;<br/>
        </strong>
        <facil:cuerpoTag>etiqueta con cuerpo</facil:cuerpoTag>><br/>
        <p>
            Se trata de una etiqueta con cuerpo (body) y sin atributos.<br/>
            El resultado del texto superior ha sido generado por una clase java CuerpoTag.java,<br/>
            que extiende de BodyTagSupport y su descriptor de librer&iacute;a de etiquetas <br/>
            es (taglib.tld) y esta p&aacute;gina etiquetaCuerpo.jsp
        </p>
        <p><a href="index.jsp">Volver a inicio (index.jsp)</a></p>
    </body>
</html>