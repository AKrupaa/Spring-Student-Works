<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 01.12.2020
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="content">
    <form:form method="post" action="addAppUserRole.html" modelAttribute="appUserRole">
        <table>
            <tr>
                <td>
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="role"><spring:message code="label.role"/></form:label></td>
                <td><form:input path="role"/></td>
                <td><form:errors path="role"/></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value=<spring:message code="label.addAppUserRole"/>>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
