<%@include file="WEB-INF/jspf/header.jspf" %>   
<h1>DVD aktualisieren</h1>

<form method="POST" action="ctrldvdupdate">
    <fieldset>
        <table>
            <tr>
                <td><label for="titel">Titel:</label></td>
                <td><input type="text" name="titel" value="${dvd.titel}"></td>                        
            </tr>
            <tr>
                <td><label for="laenge">Länge:</label></td>
                <td><input type="text" name="laenge" value="${dvd.laenge}"></td>                        
            </tr>
            <tr>
                <td><label for="erscheinungsjahr">Erscheinungsjahr:</label></td>
                <td><input type="text" name="erscheinungsjahr" value="${dvd.erscheinungsjahr}"></td>                        
            </tr>

            <tr>
                <td><label for="genre">Genre:</label></td>
                <td><select name="gid">
                        <c:forEach var="genre" items="${genreList}">
                            <option value="${genre.number}">${genre.name}</option>
                        </c:forEach>
                    </select></td>                        
            </tr>

            <tr>
                <td><label for="sprache">Sprache:</label></td>
                <td>
                    <c:forEach var="sprache" items="${spracheList}">
                        <input type="checkbox" name="sprache" value="${sprache.number}">${sprache.name} </br>
                    </c:forEach>
                </td>
            </tr>



            <tr>
                <td><label for="fsk">FSK:</label></td>
                <td><select name="fsk">
                        <option value="0">0</option>
                        <option value="6">6</option>
                        <option value="12">12</option>
                        <option value="16">16</option>
                        <option value="18">18</option>
                    </select></td>                        
            </tr>
        </table>
        <input type="submit" value="Hinzufügen">

    </fieldset>
</form>

<a href="ctrlselectadmin">zurück</a>
</body>
</html>
