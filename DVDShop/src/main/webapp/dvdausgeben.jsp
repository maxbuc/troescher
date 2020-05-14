<%@include file="WEB-INF/jspf/header.jspf" %>   

<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href=https://fonts.googleapis.com/css?family=Teko">
    
   
</head>
    <form method="GET" action="ctrlsearchdvd">
	<input type="text" name="titel" placeholder="Was suchst du?">
        <input type="submit" value="Suche">
    </form>

    <table border="1">
        <thead>
        <tr>
            <th>Titel</th>
            <th>Länge</th>
            <th>FSK</th>
            <th>Details</th>
        </tr>
        </thead>
        <tfoot>
           <tr>
            <td colspan="3">Zum Teil [...] neu aufgelegt</td>
           </tr>
        </tfoot>
        <tbody>
        <c:forEach var="dvd" items="${dvdList}">
            <tr>
                <td>${dvd.titel}</td>
                <td>${dvd.laenge}</td>
                <td>${dvd.fsk}</td>
                <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>        
    </table>
</body>
</html>
