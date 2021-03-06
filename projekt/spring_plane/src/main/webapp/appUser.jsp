<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>App user page</title>
</head>
<body>
<h1>App user info:</h1>
<form:form method="post" action="addAppUser.html" modelAttribute="customUserDomain">

    <table>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName" /></td>
            <td><form:errors path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName" /></td>
            <td><form:errors path="lastName" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email" /></td>
            <td><form:errors path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="telephone">Telephone</form:label></td>
            <td><form:input path="telephone" /></td>
            <td><form:errors path="telephone" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add CustomUser"/>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>

