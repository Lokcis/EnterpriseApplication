<%-- 
    Document   : index
    Created on : 20/06/2025, 06:24:08 PM
    Author     : lokci
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Calculadora JSP</title>
    </head>
    <body>
        <h1>Calculadora</h1>
        <form action="callServlet" method="POST">
            <label>Primer Número:</label><br>
            <input type="text" name="num1"><br><br>

            <label>Segundo Número:</label><br>
            <input type="text" name="num2"><br><br>

            <input type="submit" name="action" value="Sumar" />
            <input type="submit" name="action" value="Restar" />
            <input type="submit" name="action" value="Multiplicar" />
            <input type="submit" name="action" value="Dividir" />
            <input type="submit" name="action" value="Modulo" />
            <input type="submit" name="action" value="Cuadrado" />
        </form>
    </body>
</html>