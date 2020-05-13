<%@include file="WEB-INF/jspf/header_admin.jspf" %>  
<h1>DVD aktualisieren</h1>

<form method="POST" action="ctrlupdatedvd">
    <fieldset>
        <input type="hidden" name="did" value="${dvd.did}">
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
                <td><select name="gid" >
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
                <td><select name="fsk">
                        <c:forEach var="fsk" items="${fskList}">
                            <option value="${fsk}">${fsk}</option>
                        </c:forEach>
                    </select></td>                        
            </tr>
        </table>
        <input type="submit" value="Ändern">

    </fieldset>
</form>

<a href="ctrlselectadmin">zurück</a>
</body>
</html>
