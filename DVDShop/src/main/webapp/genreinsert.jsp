<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<h1>Genre �bersicht</h1>
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
            <td><input type="text" name="name" placeholder="Neues Genre einf�gen"></td>
            <td><input type="submit" value="Hinzuf�gen"></td>
            </tr>
    </table>
</form>
<a href="ctrlselectadmin">zur�ck zur Gesamt�bersicht</a>
</body>
</html>
