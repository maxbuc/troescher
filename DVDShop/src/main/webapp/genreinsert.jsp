<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<head>
    <style>
        input {
                width: 30%;
                padding: 4px;
                border: 1px solid grey;
                border-radius: 5px;
                box-sizing: border-box;
            }
            input[type=text]{
              position: relative;
                left: 30%;
                bottom: 200px; /*Wie hoch soll er sein?*/
                width: 20%;
            }
         input[type=submit]:hover {
                background-color: white;/*Farbe wenn man über suchebutton fährt*/   
                color: #48D1CC;
                border-radius: 5px;
            }
            
            input[type=submit] /*Button Speichern*/{
                position: relative;
                left: 30%;
                bottom: 200px; /*Wie hoch soll er sein?*/
                width: 20%;
                background-color: white;
                color: #009999;
                padding: 5px 25px; /*Größe, Breite,Länge*/
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-family: "Teko";
                font-size: 20px;
                text-align:center;
                margin-bottom: 10px;
            }
           table tr:hover{
                background-color: #48D1CC;
                color:black;
            }
            table {
                position:relative;
                top: -300px;
                left: 25%;
                width:50%;
                text-align: center;
                
            }
    </style>
</head>
<table border="1">
    <tr>
        <th>Genre</th>
    </tr>

    <c:forEach var="genre" items="${genreList}">
        <tr>
            <td>${genre}</td> 

        </tr>
    </c:forEach>


</table>
<form method="POST" action="ctrlgenreinsert">
        <tr><form method="POST" action="ctrlspracheinsert">
            <td><input type="text" name="name" placeholder="Neues Genre einfügen" required="required"></td>
            <td><input type="submit" value="Hinzufügen"></td>
            </tr>

</form>

</body>
</html>
