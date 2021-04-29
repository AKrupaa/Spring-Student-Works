<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 04.01.2021
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <title>Title</title>--%>
</head>
<body class="bg-dark">
<main class="flex-shrink-0 text-white">
    <div class="container">
        <br>
        <br>
        <br>

        <%--        <form action="/use"></form>--%>

        <div class="form-group row">
            <label for="inputEmail" class="col-sm-2 col-form-label"><spring:message code="delete"/>Welcome</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail"
                       placeholder="${pageContext.request.userPrincipal.name}" disabled="true"/>
            </div>
        </div>

        <%--        <form action="/user/"></form>--%>
        <form:form method="post" action="/user" modelAttribute="modelUser">
            <form:hidden path="id"/>
            <div class="form-group row">
                <form:label path="firstName" for="inputFirstName"
                            class="col-sm-2 col-form-label"><spring:message code="firstname"/></form:label>
                <div class="col-sm-10">
                    <form:input path="firstName" type="text" class="form-control" id="inputFirstName"
                                placeholder="first name"/>
                    <form:errors path="firstName" type="text" class="form-control" id="inputFirstName"
                                 placeholder="first name"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="lastName" for="inputLastName" class="col-sm-2 col-form-label"><spring:message code="lastname"/></form:label>
                <div class="col-sm-10">
                    <form:input path="lastName" type="text" class="form-control" id="inputLastName"
                                placeholder="last name"/>
                    <form:errors path="lastName" type="text" class="form-control" id="inputLastName"
                                 placeholder="last name"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="telephone" for="inputTelephone"
                            class="col-sm-2 col-form-label"><spring:message code="telephone"/></form:label>
                <div class="col-sm-10">
                    <form:input path="telephone" type="text" class="form-control" id="inputTelephone"
                                placeholder="telephone"/>
                    <form:errors path="telephone" type="text" class="form-control" id="inputTelephone"
                                 placeholder="telephone"/>
                </div>
            </div>
            <div class="form-group row">
                <button type="submit" class="btn btn-primary"><spring:message code="submit"/></button>
            </div>
        </form:form>

        <br>
    </div>
    <br>
    <br>
    <br>
</main>
</body>
</html>
