<%@include file="WEB-INF/jspf/header_admin.jspf" %>   
        <table border="1">
            <tr>
                <th>Titel</th>
                <th>L�nge</th>
                <th>FSK</th>
                <th>�ndern</th>
                <th>L�schen</th>
          
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.fsk}</td>
                    <td><a href="ctrlupdateselectdvd?did=${dvd.did}">�ndern</a></td>
                    <td><a href="ctrldeleteselectdvd?did=${dvd.did}">L�schen</a></td>
                    
                </tr>
            </c:forEach>
                <tr><th colspan="5"><a href="ctrldvdinsertselect">Add</a></th></tr>  
        </table>
    </body>
</html>
