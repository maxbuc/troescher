<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<h1>Sprachen �bersicht</h1>
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
            <td><input type="text" name="name" placeholder="Neue Sprache einf�gen"></td>
            <td><input type="submit" value="Hinzuf�gen"></td>
            </tr>
    </table>
</form>

<a href="ctrlselectadmin">zur�ck zur Gesamt�bersicht</a>

</body>
</html>
