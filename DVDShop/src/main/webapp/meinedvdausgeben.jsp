<%@include file="WEB-INF/jspf/header.jspf" %>   

<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href=https://fonts.googleapis.com/css?family=Teko">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
   
</head>
    
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
                <td><a href="ctrlselectdetailmydvd?did=${dvd.did}">Details</a></td>

            </tr>
        </c:forEach>

    </table>
<a href="ctrlselect">zurück zur Gesamtübersicht</a>
</body>
</html>
