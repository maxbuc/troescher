<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<h1>Sprachen Übersicht</h1>
<table border="1">
    <tr>
        <th>Sprache</th>
    </tr>

    <c:forEach var="sprache" items="${spracheList}">
        <tr>
            <td>${sprache}</td> 

        </tr>
    </c:forEach>


</table>
<form method="POST" action="ctrlspracheinsert">
    <table>
        <tr><form method="POST" action="ctrlspracheinsert">
            <td><input type="text" name="name" placeholder="Neue Sprache einfügen"></td>
            <td><input type="submit" value="Hinzufügen"></td>
            </tr>
    </table>
</form>

<a href="ctrlselectadmin">zurück zur Gesamtübersicht</a>

</body>
</html>
