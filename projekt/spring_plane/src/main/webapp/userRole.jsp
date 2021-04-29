<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 14:56
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

    <form:form modelAttribute="userRoleModel" method="post" action="/userRole">

        <%--        <div class="mb-3">--%>
        <%--            <label for="exampleFormControlInput1" class="form-label">Email address</label>--%>
        <%--            <form:hidden path="id" type="text" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">--%>
        <%--        </div>--%>
        <form:hidden path="id"/>

        <div class="mb-3 mt-3">
            <label for="exampleFormControlInput1" class="form-label">User Role</label>
            <form:input path="role" type="text" class="form-control" id="exampleFormControlInput1"/>
            <button type="submit" value="Submit">Submit</button>
        </div>

    </form:form>

    <c:if test="${!empty presentUserRoles}">
        Roles:<br>
        <c:forEach items="${presentUserRoles}" var="role" varStatus="status">
            <p>${status.index} - ${role.role}</p>
        </c:forEach>
    </c:if>
</main>

</body>
</html>
