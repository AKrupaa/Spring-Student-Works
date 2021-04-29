<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 16.12.2020
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%--    <!-- Required meta tags -->--%>
    <%--    <meta charset="utf-8">--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>

    <%--    <!-- Bootstrap CSS -->--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">--%>

    <%--    <title>Title</title>--%>
    <script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body class="text-center text-white bg-dark d-flex align-items-center justify-content-center">
<!-- Option 2: Separate Popper and Bootstrap JS -->
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"--%>
<%--        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"--%>
<%--        crossorigin="anonymous"></script>--%>

<div class="container-fluid">
    <div class="container">

        <div class="row">

            <c:if test="${!empty Information}">
                <div class="row">
                        <%--            <div class="col-md-5">--%>
                        <%--                <h1><spring:message code="regLog.signup"/></h1>--%>
                        <%--            </div>--%>
                        <%--            <div class="col-md-2">--%>

                        <%--                <h2><spring:message code="regLog.or"/></h2>--%>
                        <%--            </div>--%>
                        <%--            <div class="col-md-5">--%>
                        <%--                <h1><spring:message code="regLog.login"/></h1>--%>
                        <%--            </div>--%>
                    <div class="col-md-12">
                        <h2 class="alert alert-info">${Information}</h2>
                    </div>
                </div>
            </c:if>

            <div class="col-md-5">
                <h1><spring:message code="regLog.signup"/></h1>
            </div>
            <div class="col-md-2">
                <h2><spring:message code="regLog.or"/></h2>
            </div>
            <div class="col-md-5">
                <h1><spring:message code="regLog.login"/></h1>
            </div>
        </div>

        <%--    </div>--%>
        <hr>
        <div class="row">
            <div class="col-md-5">
                <%--                                <form method="post" action="<c:url value='/register'/>">--%>
                <%--                <form action="/register"></form>--%>
                <form:form method="post" action="/register" modelAttribute="modelRegister">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <label for="inputEmailLogin"><spring:message code="email.address"/></label>
                        <form:input path="email" type="email" class="form-control" id="inputEmailLogin"
                                    aria-describedby="emailHelp"
                                    placeholder="Enter email"/>
                        <small id="emailHelp" class="form-text text-muted"><spring:message
                                code="secret"/></small>
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordLogin"><spring:message code="password"/></label>
                        <form:input path="password" type="password" class="form-control" id="inputPasswordLogin"
                                    placeholder="Password"/>
                    </div>


                    <div class="col-md-5">
                        <br>
                        <div class="g-recaptcha" data-sitekey="6LcxWxAaAAAAAFJO_mz78P7_zNOoEONnBQGzvvHG"></div>
                    </div>

                    <br>
                    <button type="submit" class="btn btn-primary"><spring:message
                            code="signUp"/></button>
                    <form:hidden path="enabled"/>
                </form:form>
            </div>

            <div class="col-md-2">
                <!-------null------>

            </div>

            <div class="col-md-5">
                <form action="<c:url value='/login'/>" method="post">
                    <div class="form-group">
                        <c:if test="${not empty error}">
                            <label for="errorControl" class="col-form-label"><spring:message code="error"/></label>
                            <input id="errorControl" class="form-control" type="text" placeholder="${error}" readonly>
                        </c:if>
                        <c:if test="${not empty msg}">
                            <label for="msgControl" class="col-form-label"><spring:message code="error.msg"/></label>
                            <input id="msgControl" class="form-control" type="text" placeholder="${msg}" readonly>
                        </c:if>
                    </div>

                    <div class="form-group">
                        <label for="inputEmailRegister"><spring:message code="email.address"/></label>
                        <input type="email" class="form-control" id="inputEmailRegister"
                               placeholder="Enter email" name="email" value="">
                    </div>
                    <div class="form-group">
                        <label for="inputPasswordRegister"><spring:message code="password"/></label>
                        <input type="password" class="form-control" id="inputPasswordRegister" placeholder="Password"
                               name="password">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary"><spring:message code="login"/></button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>


            <%--            <div class="row">--%>
            <%--                <div class="col-md-2">--%>

            <%--                </div>--%>
            <%--                <div class="col-md-2">--%>


            <%--                </div>--%>
            <%--                <div class="col-md-5">--%>
            <%--                    <div class="g-recaptcha" data-sitekey="6LcxWxAaAAAAAFJO_mz78P7_zNOoEONnBQGzvvHG"></div>--%>
            <%--                </div>--%>
            <%--            </div>--%>

        </div>
    </div>
</div>
</body>
</html>
