<%@include file="WEB-INF/jspf/header.jspf" %>  
<head>
    <style>
        .button {
        background-color: #009999;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: right;
        margin-top: -100px;
      }
      .button:hover {
        background-color: white;
        color: #009999;
      }
      .button.row:after {
        content: "";
        display: table;
        clear: both;
      }
      input[type=submit] /*Button Meine DVDs*/{
                position: relative;
                bottom: 40px; /*Button ausrichten*/
                left:580px;
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

      
      table{
    width:100%;
    position:relative;
    margin-top: -80px;
    left: 0px;
    border: 2px solid white;
    background-color: white;
    border-radius: 3px;
    font-size: 80px;
    
}


table td, table th{
    padding: 10px 20px;
    border: none;
    font-size: 17px;

    
}

 th {
    background-color: grey;
    color: white;
    font-size: 80%;
}

table tr {
    background-color: #48D1CC;
    color: black;
    font-size: 30px;
}

table tr:hover {
    background-color: #48D1CC;
    color: black;
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
        
    </tr>
</table>

</body>
<footer>
    <p> </p>
    <a href="ctrlselectausgeliehen" class="button">Meine DVDs</a>
</footer>
</html>
