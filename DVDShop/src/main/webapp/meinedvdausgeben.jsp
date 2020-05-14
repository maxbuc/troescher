<%@include file="WEB-INF/jspf/header.jspf" %>   

<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href=https://fonts.googleapis.com/css?family=Teko">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    
    <style>

        .button {
        background-color: white;
        color: #009999;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        float: right;
        margin-top: -100px;
      }

      .button:hover {
        background-color: white;
        color: #48D1CC;
      }

      .button.row:after {
        content: "";
        display: table;
        clear: both;
      }
      
      table{
    width:100%;
    position:relative;
    top: -40px;
    left: 0px;
    border: 2px solid white;
    background-color: white;
    border-radius: 3px;
    font-size: 80px;
    
}


table td, table th{
    padding: 10px 20px;
    border: none;
    font-size: 17px;

    
}

 th {
    background-color: grey;
    color: white;
    font-size: 80%;
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
    </style>
   
</head>
    
    <table border="1">
        <tr>
            <th>Titel</th>
            <th>Länge</th>
            <th>FSK</th>
            <th>Details</th>

        </tr>
        <c:forEach var="dvd" items="${dvdList}">
            <tr>
                <td>${dvd.titel}</td>
                <td>${dvd.laenge}</td>
                <td>${dvd.fsk}</td>
                <td><a href="ctrlselectdetailmydvd?did=${dvd.did}">Details</a></td>

            </tr>
        </c:forEach>

    </table>
</body>
</html>
