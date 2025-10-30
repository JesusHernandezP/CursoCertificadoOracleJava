
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><title>LoginForm.jsp</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
 p,h2,h3 {font-family: Verdana, Arial;}
 form {width: 400px; font: normal bold 12px Verdana, Arial;}
 form label {display: inline-block; width: 150px;}
 form input {display: inline-block; width: 200px; margin-bottom: 10px;}
 </style>
 <title>loginForm</title>
</head>
<body>
 <h2>Identificación</h><!-- Atención a los siguientes nombres -->
<form method="POST" action="j_security_check">
<label for="nom">Nombre de usuario: </label>
<input type="text" name="j_username"/>
<label for="con">Contraseña: </label>
<input type="password" name="j_password"/>
<input type="submit" value="Login"/>
<input type="reset" value="Borrar"/>
</form>
<p><a href="/SegurFORM/index.jsp">Volver</a></p>
</body>
 </html>
