<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<h1>Genre Übersicht</h1>
<table border="1">
    <tr>
        <th>Genre</th>
    </tr>

    <c:forEach var="genre" items="${genreList}">
        <tr>
            <td>${genre}</td> 

        </tr>
    </c:forEach>


</table>
<form method="POST" action="ctrlgenreinsert">
    <table>
        <tr><form method="POST" action="ctrlspracheinsert">
            <td><input type="text" name="name" placeholder="Neues Genre einfügen"></td>
            <td><input type="submit" value="Hinzufügen"></td>
            </tr>
    </table>
</form>
<a href="ctrlselectadmin">zurück zur Gesamtübersicht</a>
</body>
</html>
