<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<head>
    <style>
        table{
                width:90%;
                position:relative;
                top: -250px;
                left: 35px;
                font-family: "Teko";
                font-size: 20px;
                border:3px solid #48D1CC;
            }
           table td, table th{
            padding: 10px 10px;
            border: 3px solid #48D1CC;;
            font-size: 17px;
        }

        table tr {
            background-color: #48D1CC;
            color: black;
            font-size: 30px;
        }

        table tr:hover {
            background-color: white;
            color: #48D1CC;
            border: 2px solid black;
        }
            table.doFixed {
                table-layout: fixed;
            }
            /*.doAutoWidth {
           width: auto;
        }*/


            table td {
                text-align: left;
                border: 1px solid #48D1CC;
            }

            .kleiner {
                width: 20%;
            }
            .auchKleiner {
                width: 50%;
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
                heidth: 50%;

            }
            input {
                width: 80%;
                padding: 6px;
                border: 1px solid black;
                border-radius: 5px;
                box-sizing: border-box;
            }
            input[type=text]{
                width: 80%;
                padding: 6px;
                border: 1px solid black;
                border-radius: 5px;
                box-sizing: border-box;
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
            
            table tr:hover {
            background-color: #48D1CC;
            color: white;

        }
    </style>
</head>
<div class="container">
<form method="POST" action="ctrlupdatedvd">
        <input type="hidden" name="did" value="${dvd.did}">
        
        <table>
            <tr>
                <td><label for="titel">Titel:</label></td>
                <td><input type="text" name="titel" value="${dvd.titel}" required="required"></td>                        
            </tr>
            <tr>
                <td><label for="laenge">Länge:</label></td>
                <td><input type="text" name="laenge" value="${dvd.laenge}" required="required"></td>                        
            </tr>
            <tr>
                <td><label for="erscheinungsjahr">Erscheinungsjahr:</label></td>
                <td><input type="text" name="erscheinungsjahr" value="${dvd.erscheinungsjahr}" required="required"></td>                        
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
                <td><label for="sprache">Sprache:</label></td>
                <td>
                    <c:forEach var="sprache" items="${spracheChecked}">
                        <input type="checkbox" name="sprache" value="${sprache.number}" checked>${sprache.name} </br>
                    </c:forEach>
                    <c:forEach var="spracheU" items="${spracheUnchecked}">
                        <input type="checkbox" name="sprache" value="${spracheU.number}">${spracheU.name} </br>
                    </c:forEach>
                </td>
            </tr>



            <tr>
                <td><label for="fsk">FSK:</label></td>
                <td><select name="fsk" required="required">
                        <c:forEach var="fsk" items="${fskList}">
                            <option value="${fsk}">${fsk}</option>
                        </c:forEach>
                    </select></td>                        
            </tr>
        </table>
        <input type="submit" value="Ändern">
        </div>

</form>
</body>
</html>
