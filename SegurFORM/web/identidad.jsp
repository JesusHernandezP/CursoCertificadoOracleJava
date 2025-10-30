

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Identidad</title>
 <style type="text/css">h3.rojo {color: crimson;}</style>
 <style type="text/css">h3.verd {color: green;}</style>
 </head>
 <body>
 <h2>Inicio usuario</h2>
 <%
 String tipoAutenticacion = request.getAuthType();
 String usuario = request.getRemoteUser();
 if (usuario == null) {
 
 out.println("<h3 class='rojo'>tipo de autenticación: " +
tipoAutenticacion + "</h3>");
 }else{
 out.println("<h3 class='verd'>Hola, " + usuario + "<br/></h3>");
 out.println("<h3 class='verd'>tipo de autenticación: " +
tipoAutenticacion + "</h3>");
 out.println("<p><a href='logout.jsp'>Salir del usuario '" + usuario +
"'</a></p>");
 }
 %>
 <p><a href="index.jsp">Volver</p>
</body>
</html>

