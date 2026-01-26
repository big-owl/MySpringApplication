<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <title>REST Endpoints Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style>
        .red {
            color: #ff0000;
        }
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <H1>REST Endpoints Test Page</H1>
    <br>
    <form:form method="POST" action="/application/user/update" modelAttribute="user">
        <table>
            <tr>
                <td colspan=3><span class="red">${errorMessage}</span></td>
            </tr>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id" type="number"/>
                <td><form:errors path="id" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" />
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr><td>&nbsp;</td></tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
    <br>
    Get User Name By Id - <a href=/application/user/${id}/name>/user/${id}/name</a>
    <br>
</body>
</html>
