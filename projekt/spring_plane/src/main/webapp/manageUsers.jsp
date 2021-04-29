<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<main class="container">
    <%--    <tr>--%>
    <%--        <td><form:label path="appUserRole"><spring:message code="label.role"/></form:label></td>--%>
    <%--        <td><form:select path="appUserRole" multiple="true">--%>
    <%--            <form:options items="${appUserRoleList}" itemValue="id" itemLabel="role"/>--%>
    <%--        </form:select></td>--%>
    <%--        <td><form:errors path="appUserRole"/></td>--%>
    <%--    </tr>--%>

    <c:if test="${!empty presentUsers}">
        Available users:<br>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Last name</th>
                <th scope="col">Email</th>
                <th scope="col">Login</th>
                <th scope="col">Enabled</th>
                    <%--                    <th scope="col">User Roles</th>--%>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
                <th scope="col">Toggle</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${presentUsers}" var="user" varStatus="status">
                <tr>
                    <th scope="row">${status.index}</th>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.login}</td>
                    <td>${user.enabled}</td>
                        <%--                    <td><form:select path="appUserRole" multiple="true">--%>
                        <%--                        <form:options items="${userRoleList}" itemValue="id" itemLabel="role" disabled="true"/>--%>
                        <%--                    </form:select></td>--%>
                        <%--        <c:forEach items="${presentUsers}" var="user" varStatus="status">--%>

                    <td><a href="/user/edit/${user.id}">edit</a></td>
                    <td><a href="/user/delete/${user.id}">delete</a></td>
                    <td><a href="/user/toggle/${user.id}">toggle (enabled)</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>

</main>

</body>
</html>
