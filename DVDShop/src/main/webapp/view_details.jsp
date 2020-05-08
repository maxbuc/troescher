<%-- 
    Document   : view_details
    Created on : 07.05.2020, 14:13:18
    Author     : Maximilian
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DVD Details</h1>
        <table>
            <tr>
                <th>Nr.</th>
                <th>Nr.</th>
                <th>Titel</th>
                <th>Länge</th>
                <th>Erscheinungsjahr</th>
                <th>FSK</th>
            </tr>
            
                <tr>
                    <td>${dvd.titel}</td>
                    <td>${dvd.Titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.erscheinungsjahr}</td>
                    <td>${dvd.fsk}</td>   
                    
                </tr>
            
                
        </table>
    </body>
</html>
