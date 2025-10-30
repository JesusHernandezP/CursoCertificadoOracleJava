<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
        <style type="text/css">
            p,h2,h3 {font-family: Verdana, Arial;}
        </style>
    </head>
    <body>
        <h2>Haciendo logout</h2>
        <h3>Página de salida del sistema</h3>
        <%
            if (session != null) {
                session.invalidate();
            } else {
                out.println("No hay sesión de usuario conocida actualmente");
            }
        %>
        <p><a href="admin/index.jsp">Volver</a></p>
    </body>
</html>
