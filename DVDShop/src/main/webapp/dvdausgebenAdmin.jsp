<%@include file="WEB-INF/jspf/header_admin.jspf" %>   
        <table border="1">
            <tr>
                <th>Titel</th>
                <th>Länge</th>
                <th>FSK</th>
                <th>Ändern</th>
                <th>Löschen</th>
          
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.fsk}</td>
                    <td><a href="ctrlupdateselectdvd?did=${dvd.did}">Ändern</a></td>
                    <td><a href="ctrldeleteselectdvd?did=${dvd.did}">Löschen</a></td>
                    
                </tr>
            </c:forEach>
                <tr><th colspan="5"><a href="ctrldvdinsertselect">Add</a></th></tr>  
        </table>
    </body>
</html>
