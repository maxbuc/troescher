<%@include file="WEB-INF/jspf/header.jspf" %>   
<h1>Unser DVD-Shop</h1>
        <table border="1">
            <tr>
                <th>Nr.</th>
                <th>Titel</th>
                <th>Länge</th>
                <th>FSK</th>
                <th>${kunde.email}</th>
          
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.did}</td>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.fsk}</td>
                    <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>
                    
                </tr>
            </c:forEach>
                
        </table>
    </body>
</html>
