<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>User View</title>
</head>
<body>

<h2>User Information</h2>
<table>
    <tr>
        <td>ID :</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Name :</td>
        <td>${name}</td>
    </tr>
</table>
<br>
<a href="/application/">Return to Home Page</a>
</body>
</html>
