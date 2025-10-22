/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ejemplos.servlets;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Ejemplo de acceso a base de datos por medio de un Pool de Conexiones
 * @author Pedro Díaz Gómez, Madrid, 20-06-2008
 */
@WebServlet(name = "PoolDBServlet", urlPatterns = {"/PoolDBServlet"})
public class PoolDBServlet extends HttpServlet {
    private DataSource fuenteDatos;
    private Context context;

    @Override
    public void init(ServletConfig config) {
        System.out.println(" > Servlet PoolDBServlet se ha iniciado");
        try {
            context = new InitialContext();
            System.out.print(" > Cargando un contexto JNDI...");
            fuenteDatos = (DataSource) context.lookup("jdbc/artic");
            System.out.println(" ¡hecho!");
        } catch (NamingException e) {
            System.out.println(" > Falló el contexto JNDI...");
            System.exit(1); // Si no funciona el contexto, abortamos el programa y salimos
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        Connection con = null; // Conexión a la BBDD
        Statement sen = null; // Para enviar sentencias a la BBDD
        ResultSet resul = null; // Donde recibiremos los resultados de la consulta
        String consultaSQL = "";
        StringBuffer cad = new StringBuffer();	// Cadena que formará la página HTML

        try {
            // Paso 1/6: Cargar controlador de la BBDD (innecesario con Pool de BBDD)
            // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); (innecesario en Java 8)
            // Tampoco cargamos el driver, por tratarse de un Pool de conexiones
            // Paso 2/6: Establecer conexión con la fuente de datos (BBDD)
            con = fuenteDatos.getConnection();	// Pedimos una conexión libre...

            // Paso 3/6: Inicializar una sentencia a partir de la conexión previa
            sen = con.createStatement();

            consultaSQL = "SELECT IDPROD, CATEGORIA, DESCRIPCION, PRECIO FROM ARTICULOS";
            System.out.println(consultaSQL);

            // Paso 4/6: Ejecutar la sentencia SQL y recoger resultados
            resul = sen.executeQuery(consultaSQL);
            String descrip, categ;
            int idProd, totReg = 0;
            float precio;

            // Paso 5/6 Iterar sobre el objeto "res" para obtener filas con las que creamos
            // Articulos que metemos en una cadena de texto alterable (StringBuffer).
            cad.append("\t\t<center>\n\t\t\t<table border='1' BGCOLOR='#9090BB'>\n");
            cad.append("\t\t\t\t<tr><th>Id.</TH><TH>Categor&iacute;a</th><th>Descripci&oacute;n producto</th><th>Precio</th></tr>");

            // Paso 6/6: Iterar sobre el objeto "res" para listar las filas
            while (resul.next()) {
                idProd = resul.getInt("IDPROD");
                categ = resul.getString("CATEGORIA");
                descrip = resul.getString("DESCRIPCION");
                precio = Float.parseFloat(resul.getString("PRECIO"));
                cad.append("\n\t\t\t\t<tr><td align='right'>")
                        .append(idProd)
                        .append("</td>" + "<td>")
                        .append(categ).append("</td>" + "<td>")
                        .append(descrip).append("</td>" + "<td align='right'>")
                        .append(precio).append("</td></tr>");
                totReg++;
            }
            resul.close();
            sen.close();
            // La conexión la cerramos en el finally para devolverla al Pool

            cad.append("\n\t\t\t</table>\n\t\t</center>");
            PrintWriter out = res.getWriter();	// Preparamos e imprimimos la página HTML dinámica 
            out.println("<html>\n\t<head><title>PoolDBServlet</title></head>");
            out.println("\t<body bgcolor='#AABBDD'>");
            out.println("\t\t<h2><strong>Acceso a base de datos con Pool de Conexiones</strong></h2>");
            out.println("\t\t<p/><hr/>");
            out.println("\t\tServlet de Pedro");
            out.println(cad);
            out.println("\t\t<br/><br/>");
            out.println("\t\t<hr/>");
            out.println("\t\t<font size='6' color='#998877'>Total de registros: <strong>" + totReg + "</strong></font>");
            out.println("\t</body>\n</html>");
            out.close();
        } catch (SQLException | NumberFormatException | IOException e) {
            // Control de errores unificado
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {}
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println(" > El servlet PoolDBServlet se ha descargado de memoria");
    }
}
