<%@include file="WEB-INF/jspf/header_admin.jspf" %>
<head>
    <style>
        h34 {
            position:relative;
            top:100px;
            text-align: center;
            font-size: 20px;
        }
        
        table {
            position: relative;
            top: -250px;
                
        }
        
         .container {
                padding: 20px 20px;
                position: relative;
                left: 285px;
                margin-top: 30px;
                margin-bottom: 75px;
                border-radius: 5px;
                background-color: #48D1CC;
                border: 2px solid white; /*richtig*/
                width: 50%;
                heidth: 25%;
                overflow: visible;

            }
            input[type=submit]:hover {
                background-color: white;/*Farbe wenn man über suchebutton fährt*/   
                color: #48D1CC;
                border-radius: 5px;
            }
            
            input[type=submit] /*Button Speichern*/{
                position: relative;
                top: -200px;
                left: 250px;
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
                
            }
    </style>
</head>



<form method="POST" action="ctrldvdinsert">
    <div class="container">
        <h34>Neue DVD hinzufügen</h34>
        <table>
            <tr>
                <td><label for="titel">Titel:</label></td>
                <td><input type="text" name="titel" placeholder="Titel eingeben" required="required"></td>                        
            </tr>
            <tr>
                <td><label for="laenge">Länge:</label></td>
                <td><input type="number" name="laenge" placeholder="" required="required"></td>                        
            </tr>
            <tr>
                <td><label for="erscheinungsjahr">Erscheinungsjahr:</label></td>
                <td><input type="number" name="erscheinungsjahr" placeholder="2020" min="1900" max="2020" required="required"></td>                        
            </tr>

            <tr>
                <td><label for="genre">Genre:</label></td>
                <td><select name="gid" required="required">
                        <c:forEach var="genre" items="${genreList}">
                            <option value="${genre.number}">${genre.name}</option>
                        </c:forEach>
                    </select></td>                        
            </tr>

            <tr>
                <td><label for="sprache">Sprache: (default=deutsch)</label></td>
                <td>
                    <c:forEach var="sprache" items="${spracheList}">
                        <input type="checkbox" name="sprache" value="${sprache.number}">${sprache.name} </br>
                    </c:forEach>
                </td>
            </tr>



            <tr>
                <td><label for="fsk">FSK:</label></td>
                <td><select name="fsk" required="required">
                        <option value="0">0</option>
                        <option value="6">6</option>
                        <option value="12">12</option>
                        <option value="16">16</option>
                        <option value="18">18</option>
                    </select></td>                        
            </tr>
        </table>
        <input type="submit" value="Hinzufügen">

    </div>
</form>



</body>
</html>
