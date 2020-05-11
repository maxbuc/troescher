<%@include file="WEB-INF/jspf/header.jspf" %>  
        <h1>DVD Details</h1>
        <table>
            <tr>
                <th>Titel</th>
                <th>Länge</th>
                <th>Erscheinungsjahr</th>
                <th>FSK</th>
                <th>Sprachen</th>
                <th>Verfügbarkeit</th>
            </tr>
            
                <tr>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.erscheinungsjahr}</td>
                    <td>${dvd.fsk}</td>   
                    <td>
                         <c:forEach var="sprache" items="${dvd.sprache}">
                             ${sprache},
                         </c:forEach>
                    </td>
                    <td>
                            ${dvd.verfuegbar}
                    </td>
                </tr>
        </table>
                <form action="ctrlreserve" method="POST">  
                    <input type="hidden" value="${dvd.did}" name="did">
                    <input type="submit" value="Leih mich!">
                </form>
                    
    </body>
    <footer>
        <p> </p>
        <a href="ctrlselect">zurück zur Übersicht</a>
    </footer>
</html>
