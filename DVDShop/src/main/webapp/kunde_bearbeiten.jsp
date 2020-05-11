<%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Ihr G‰stebucheintrag</h1>
        <form method="POST" action="ctrlupdatekunde">
            <input type="hidden" name="kid" value="${kunde.kid}">
            <fieldset>
                <table>
                    <tr>
                        <td>Vorname:</td>
                        <td><input type="text" name="vorname" value="${kunde.vorname}"></td>                        
                    </tr>
                     <tr>
                        <td><label for="nachname">Nachname:</label></td>
                        <td><input type="text" name="nachname" value="${kunde.nachname}"></td>                        
                    </tr>
                    
                     <tr>
                        <td><label for="strasse">Straﬂe:</label></td>
                        <td><input type="text" name="strasse" value="${kunde.strasse}"></td>                        
                    </tr>
                     <tr>
                        <td><label for="hausnummer">Hausnummer:</label></td>
                        <td><input type="text" name="hausnummer" value="${kunde.hausnummer}"></td>                        
                    </tr>
                     <tr>
                        <td><label for="plz">PLZ:</label></td>
                        <td><input type="text" name="plz" value="${kunde.plz}"></td>                        
                    </tr>
                     <tr>
                        <td><label for="kontonr">Kontonummer:</label></td>
                        <td><input type="text" name="kontonr" value="${kunde.kontonr}"></td>                        
                    </tr>
                    
                    <tr>
                        <td><label for="email">Deine E-Mail:</label></td>
                        <td><input type="email" name="email" value="${kunde.email}"></td>                        
                    </tr>
                     <tr>
                        <td><label for="passwort">Passwort:</label></td>
                        <td><input type="text" name="passwort" value="${kunde.passwort}"></td>                        
                    </tr>
                    
                    <tr>
                        <td colspan="2"><input type="submit" value="Speichern"></td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </body>
</html>