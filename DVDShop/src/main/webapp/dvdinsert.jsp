<%@include file="WEB-INF/jspf/header.jspf" %>  
<h1>Neue DVD</h1>

<form method="POST" action="ctrldvdinsert">
    <fieldset>
        <table>
            <tr>
                <td><label for="titel">Titel:</label></td>
                <td><input type="text" name="titel" placeholder="Titel eingeben"></td>                        
            </tr>
            <tr>
                <td><label for="laenge">L�nge:</label></td>
                <td><input type="text" name="laenge" placeholder="L�nge eingeben"></td>                        
            </tr>
            <tr>
                <td><label for="erscheinungsjahr">Erscheinungsjahr:</label></td>
                <td><input type="text" name="erscheinungsjahr" placeholder="Jahr eingeben"></td>                        
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
        <input type="submit" value="Hinzuf�gen">

    </fieldset>
</form>

<a href="ctrlselectadmin">zur�ck</a>


</body>
</html>
