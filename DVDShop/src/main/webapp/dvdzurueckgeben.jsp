<%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>DVD zur�ckgeben</h1>
        <table border="1">
        <tr>
            <th>Titel</th>
            <th>zurckgeben</th>

        </tr>
        <c:forEach var="dvd" items="${dvdList}">
            <tr>
                <td>${dvd.titel}</td>
                <td><a href="ctrlzurueckgeben?did=${dvd.did}">ZUR�CKGEBEN</a></td>

            </tr>
        </c:forEach>

    </table>
    </body>
</html>
