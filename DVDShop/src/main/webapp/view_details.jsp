<%@include file="WEB-INF/jspf/header.jspf" %>  
<head>
     <style>
        .button {
        background-color: white;
        color: #009999;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: left;
        margin-top: -100px;
      }
      .button:hover {
        background-color: #009999;
        color: white;
      }
      .button.row:after {
        content: "";
        display: table;
        clear: both;
      }
      table tr:hover {
    background-color: #48D1CC;
    color: black;
    font-size: 30px;
}

      input[type=submit] /*Button Leih mich!*/{
                position: relative;
                top: -90px; /*Button ausrichten*/
                left: 550px;
                width: 10%;
                background-color: white;
                color: #009999;
                padding: 5px 25px; /*Größe, Breite,Länge*/
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-family: "Teko";
                font-size: 20px;
                text-align:center;
            }

       input[type=submit]:hover {
                background-color: white;/*Farbe wenn man über suchebutton fährt*/   
                color: #48D1CC;
                border-radius: 5px;
            }
    </style>
</head>
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
        <td>Wurde schon ${anzahl} mal verliehen</td>
    </tr>
</table>
<c:choose>      
    <c:when test="${dvd.verfuegbar=='true'}">
        <form action="ctrlreserve" method="POST">  
            <input type="hidden" value="${dvd.did}" name="did">
            <input type="submit" value="Leih mich!">
        </form>
    </c:when>
    
</c:choose>
</body>
<footer>
    <p> </p>
    <!--<a href="ctrlselect" class="button">Alle meine DVDs</a>-->
</footer>
</html>
