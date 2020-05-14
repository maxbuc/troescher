<%@include file="WEB-INF/jspf/header.jspf" %>   

<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href=https://fonts.googleapis.com/css?family=Teko">  
    <style>
        input {
    position: relative;
    display: inline-block;
    font-size: 20px;
    box-sizing: border-box;
    transition: .5s;
    }

    input[type="text"]{
        position: relative;
        left: 900px;
        top: -210px;
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

    input[type="submit"]{
       position: relative;
       left: 900px;
       top: -210px;
       border-radius: 0 25px 25px 0;
       width: 85px;
       height: 50px;
       border: none;
       outline: none;
       cursor: pointer;
       background: #009999;
       color: white;
    }

    input[type="submit"]:hover{
        background: #48D1CC;
    }
    </style>
</head>
    <form method="GET" action="ctrlsearchdvd">
	<input type="text" name="titel" placeholder="Was suchst du?">
        <input type="submit" value="Suche">
    </form>

    <table border="1">
        <thead>
        <tr>
            <th>Titel</th>
            <th>Länge</th>
            <th>FSK</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dvd" items="${dvdList}">
            <tr>
                <td>${dvd.titel}</td>
                <td>${dvd.laenge}</td>
                <td>${dvd.fsk}</td>
                <td><a href="ctrlselectdetail?did=${dvd.did}">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>        
    </table>
</body>
</html>
