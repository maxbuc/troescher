<%@include file="WEB-INF/jspf/header.jspf" %>  
        <h1>DVD Details</h1>
        <table>
            <tr>
                <th>Titel</th>
                <th>Länge</th>
                <th>Erscheinungsjahr</th>
                <th>FSK</th>
            </tr>
            
                <tr>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.erscheinungsjahr}</td>
                    <td>${dvd.fsk}</td>   
                    
                </tr>
            
                
        </table>
    </body>
</html>
