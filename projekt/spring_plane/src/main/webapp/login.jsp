<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<main class="container">

    <%--    <form name="loginForm" action="<c:url value='/login'/>" method="post">--%>
    <form action="<c:url value='/login'/>" method="post">
        <div class="row">
            <c:if test="${not empty error}">
                <h2 class="alert alert-info">${error}</h2>
            </c:if>
        </div>
        <div class="row">
            <c:if test="${not empty msg}">
                <h2 class="alert alert-info">${msg}</h2>
            </c:if>
        </div>
        <div class="row">
            <c:if test="${not empty registered}">
                <h2 class="alert alert-info">${registered}</h2>
            </c:if>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="mb-3 mt-5">
            <label for="exampleFormControlInput1" class="form-label">Login</label>
            <input name="login" type="text" value="" class="form-control" id="exampleFormControlInput1"/>
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput2" class="form-label">Password</label>
            <div class="form-control">
                <input name="password" type="password" value="" class="form-control" id="exampleFormControlInput2"/>
            </div>
        </div>


        <button type="submit" value="submit">Submit</button>
    </form>
</main>
</body>
</html>

