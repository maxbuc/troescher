<%@include file="WEB-INF/jspf/header.jspf" %>   
<h1>Unser DVD-Shop</h1>
<form method="GET" action="ctrlsearchdvd">
    <table>
        <tr>
            <td>Suche:</td>
            <td><input type="text" name="titel"></td>
            <td><input type="submit" value="Los!"></td>
        </tr>
    </table>
</form>
<table border="1">
    <tr>
        <th>Titel</th>
        <th>Länge</th>
        <th>FSK</th>
        <th>Details</th>

    </tr>
    <c:forEach var="dvd" items="${dvdList}">
        <tr>
            <td>${dvd.titel}</td>
            <td>${dvd.laenge}</td>
            <td>${dvd.fsk}</td>
            <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
