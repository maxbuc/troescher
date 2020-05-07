<%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Unser Gästebuch</h1>
        <table>
            <tr>
                <th>Nr.</th>
                <th>Datum</th>
                <th>Verfasser</th>
                <th>E-Mail</th>
                <th>Text</th>
                <th>Löschen</th>
                <th>Ändern</th>
            </tr>
            <c:forEach var="gbEintrag" items="${gbList}">
                <tr>
                    <td>${gbEintrag.gid}</td>
                    <td>${gbEintrag.datum}</td>
                    <td>${gbEintrag.verfasser}</td>
                    <td>${gbEintrag.email}</td>
                    <td>${gbEintrag.text}</td>
                    <td><a href="ctrldelete?gid=${gbEintrag.gid}">Löschen!</a></td>
                    <td><a href="ctrlupdateselect?gid=${gbEintrag.gid}">Ändern!</a></td>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
