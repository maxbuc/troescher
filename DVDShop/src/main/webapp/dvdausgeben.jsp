<%@include file="WEB-INF/jspf/header.jspf" %>   
<h1>Unser DVD-Shop</h1>
        <table border="1">
            <tr>
                <th>Nr.</th>
                <th>Titel</th>
                <th>Länge</th>
                <th>Erscheinungsjahr</th>
                <th>FSK</th>
                <th>Details</th>
          
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.did}</td>
                    <td>${dvd.Titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.erscheinungsjahr}</td>
                    <td>${dvd.fsk}</td>
                    <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>
                    
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
