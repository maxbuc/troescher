<%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Unser G�stebuch</h1>
        <table>
            <tr>
                <th>Nr.</th>
                <th>Datum</th>
                <th>Verfasser</th>
                <th>E-Mail</th>
                <th>Text</th>
                <th>L�schen</th>
                <th>�ndern</th>
            </tr>
            <c:forEach var="gbEintrag" items="${dvdList}">
                <tr>
                    <td>${gbEintrag.gid}</td>
                    <td>${gbEintrag.datum}</td>
                    <td>${gbEintrag.verfasser}</td>
                    <td>${gbEintrag.email}</td>
                    <td>${gbEintrag.text}</td>
                    
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
