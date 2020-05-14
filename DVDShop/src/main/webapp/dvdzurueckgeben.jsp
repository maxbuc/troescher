<%@include file="WEB-INF/jspf/header_admin.jspf" %>

        <table border="1">
        <tr>
            <th>Titel</th>
            <th>Geliehen von</th>
            <th>Zurückgeben</th>

        </tr>
        <c:forEach var="dvd" items="${dvdList}">
            <tr>
                <td>${dvd.titel}</td>
                <td>${dvd.kunde}</td>
                <td><a href="ctrlzurueckgeben?did=${dvd.did}">ZURÜCKGEBEN</a></td>

            </tr>
        </c:forEach>

    </table>
    </body>
</html>
