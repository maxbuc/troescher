<%-- 
    Author     : Wolfgang Tröscher, SPE München
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="mStyle.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>G&auml;stebuch</title>
    </head>
    <body>

        <nav>
            <ul>
                <li><a href="formular_neu.jsp">Neuer Eintrag</a></li>
                <li><a href="ctrlselect">Gästebuch anzeigen</a></li>
                <li><a href="impressum.jsp">Impressum</a></li>  
            </ul>
        </nav>
        <h1>Unser Gästebuch</h1>
        <table>
            <tr>
                <th>Nr.</th>
                <th>Details</th>
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.titel}</td>
                    <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>

                </tr>
            </c:forEach>

        </table>
    </body>
</html>
