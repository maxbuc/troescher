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
            <c:forEach var="gbEintrag" items="${gbList}">
                <tr>
                    <td>${gbEintrag.gid}</td>
                    <td>${gbEintrag.datum}</td>
                    <td>${gbEintrag.verfasser}</td>
                    <td>${gbEintrag.email}</td>
                    <td>${gbEintrag.text}</td>
                    <td><a href="ctrldelete?gid=${gbEintrag.gid}">L�schen!</a></td>
                    <td><a href="ctrlupdateselect?gid=${gbEintrag.gid}">�ndern!</a></td>
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
