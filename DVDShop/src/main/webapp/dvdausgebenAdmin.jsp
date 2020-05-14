<%@include file="WEB-INF/jspf/header_admin.jspf" %>   
<head>
    <style>
         input {
    position: relative;
    display: inline-block;
    font-size: 20px;
    box-sizing: border-box;
    transition: .5s;
    }

    input[type=text]{
        position: relative;
        left: 220px;
        top: -90px;
        background: grey;
        color: white;
        width: 200px;
        height: 50px;
        border: none;
        outline: none;
        padding: 0 25px;
        border-radius: 25px 0 0 25px;
    }

    ::placeholder {
        color:white;
    }

    input[type=submit]{
       position: relative;
       left: 220px;
       top: -90px;
       border-radius: 0 25px 25px 0;
       width: 85px;
       height: 50px;
       border: none;
       outline: none;
       cursor: pointer;
       background: #009999;
       color: white;
    }

    input[type=submit]:hover{
        background: #48D1CC;
    }
    </style>
</head>
    <form method="GET" action="ctrlsearchdvd">
	<input type="text" name="titel" placeholder="Was suchst du?">
        <input type="submit" value="Suche">
    </form>
        <table border="1">
            <tr>
                <th>Titel</th>
                <th>Länge</th>
                <th>FSK</th>
                <th>Ändern</th>
                <th>Löschen</th>
          
            </tr>
            <c:forEach var="dvd" items="${dvdList}">
                <tr>
                    <td>${dvd.titel}</td>
                    <td>${dvd.laenge}</td>
                    <td>${dvd.fsk}</td>
                    <td><a href="ctrlupdateselectdvd?did=${dvd.did}">Ändern</a></td>
                    <td><a href="ctrldeleteselectdvd?did=${dvd.did}">Löschen</a></td>
                    
                </tr>
            </c:forEach>
                <tr><th colspan="5"><a href="ctrldvdinsertselect">Add</a></th></tr>  
        </table>
    </body>
</html>
