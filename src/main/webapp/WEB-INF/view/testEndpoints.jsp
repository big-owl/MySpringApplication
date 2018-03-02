<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <title>REST Endpoints Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <H1>REST Endpoints Test Page</H1><br>
    Get User Name - <a href=/application/get/name>/get/name</a><br>
    Get User Name By Id - <a href=/application/get/${id}/name>/get/${id}/name</a>
    <br>
    <br>
    <form:form method="POST" action="/application/update" modelAttribute="user">
        <table>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
