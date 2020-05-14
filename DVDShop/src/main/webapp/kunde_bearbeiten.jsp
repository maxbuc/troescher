<%@include file="WEB-INF/jspf/header.jspf" %>
<head>
    <style>
        h1 {
            position: relative;
                vertical-align: middle;
                left: 33%;
                top: 25px;
                font-family: "Teko";
                font-size: 35px;
        }
        
        table{
                width:60%;
                position:relative;
                top: -40px;
                left: 35px;
                font-family: "Teko";
                font-size: 20px;
                border:3px solid #48D1CC;
            }
           table td, table th{
            padding: 10px 10px;
            border: 1px solid #48D1CC;;
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
                top: 0px;
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
        <h1>Mein Konto</h1>
        <div class="container">
        <form method="POST" action="ctrlupdatekunde">
            <input type="hidden" name="kid" value="${kunde.kid}">
            
                <table border=1 height="50%">
                    <tr>
                        <td><label for="vorname">Vorname:</label></td>
                        <td><input type="text" name="vorname" value="${kunde.vorname}" required="required"></td>                        
                    </tr>
                     <tr>
                        <td><label for="nachname">Nachname:</label></td>
                        <td><input type="text" name="nachname" value="${kunde.nachname}" required="required"></td>                        
                    </tr>
                    
                     <tr>
                        <td><label for="strasse">Straße:</label></td>
                        <td><input type="text" name="strasse" value="${kunde.strasse}" required="required"></td>                        
                    </tr>
                     <tr>
                        <td><label for="hausnummer">Hausnummer:</label></td>
                        <td><input type="text" name="hausnummer" value="${kunde.hausnummer}" required="required"></td>                        
                    </tr>
                     <tr>
                        <td><label for="plz">PLZ:</label></td>
                        <td><input type="text" name="plz" value="${kunde.plz}" required="required"></td>                        
                    </tr>
                     <tr>
                        <td><label for="kontonr">Kontonummer:</label></td>
                        <td><input type="text" name="kontonr" value="${kunde.kontonr}" required="required"></td>                        
                    </tr>
                    
                    <tr>
                        <td><label for="email">Deine E-Mail:</label></td>
                        <td><input type="email" name="email" value="${kunde.email}" required="required"></td>                        
                    </tr>
                     <tr>
                        <td><label for="passwort">Passwort:</label></td>
                        <td><input type="text" name="passwort" value="${kunde.passwort}" required="required"></td>                        
                     </tr>
                </table>
                     <input type="submit" value="Speichern">
        </form>
        </div>
                    
    </body>
</html>