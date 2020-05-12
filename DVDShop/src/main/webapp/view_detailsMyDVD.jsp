<%@include file="WEB-INF/jspf/header.jspf" %>  
<h1>DVD Details</h1>
<table>
    <tr>
        <th>Titel</th>
        <th>Länge</th>
        <th>Erscheinungsjahr</th>
        <th>FSK</th>
        <th>Sprachen</th>
        
    </tr>

    <tr>
        <td>${dvd.titel}</td>
        <td>${dvd.laenge}</td>
        <td>${dvd.erscheinungsjahr}</td>
        <td>${dvd.fsk}</td>   
        <td>
            <c:forEach var="sprache" items="${dvd.sprache}">
                ${sprache},
            </c:forEach>
        </td>
        
    </tr>
</table>

</body>
<footer>
    <p> </p>
    <a href="ctrlselectausgeliehen">zurück zur Übersicht</a>
</footer>
</html>
