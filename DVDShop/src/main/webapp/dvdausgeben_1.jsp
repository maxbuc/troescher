<%-- 
    Author     : MIP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="mStyle.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DVD-Shop</title>
    </head>
    <body>

        <nav>
            <ul>
                <li><a href="formular_neu.jsp">Neuer Eintrag</a></li>
                <li><a href="ctrlselect">Gästebuch anzeigen</a></li>
                <li><a href="impressum.jsp">Impressum</a></li>  
            </ul>
        </nav>
        <h1>Unser DVD-Shop</h1>
        <table>
            <tr>
                <th>Nr.</th>
                <th>Titel</th>
                <th>Länge</th>
                <th>Erscheinungsjahr</th>
                <th>FSK</th>
                <th>Details</th>
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.did}</td>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.erscheinungsjahr}</td>
                    <td>${dvd.fsk}</td>
                    <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>

                </tr>
            </c:forEach>

        </table>
    </body>
</html>
