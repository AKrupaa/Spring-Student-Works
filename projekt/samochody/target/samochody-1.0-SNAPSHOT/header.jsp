<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 25.10.2020
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <title><spring:message code="title.header"/></title>--%>
    <%--    <form class="content" id="langForm" action="" method="get">--%>
    <%--        <span>--%>
    <%--            <select size="1" name="lang" onchange="form.submit()">--%>
    <%--            <option value="pl">PL</option>--%>
    <%--            <option value="en">EN</option>--%>
    <%--            <option value="de">DE</option>--%>
    <%--        </select>--%>
    <%--        </span>--%>
    <%--    </form>--%>
    <!-- Required meta tags -->
    <%--    <meta charset="utf-8">--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>

    <%--    <!-- Bootstrap CSS -->--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">--%>
</head>
<body>
<!-- Option 2: Separate Popper and Bootstrap JS -->
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"--%>
<%--        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"--%>
<%--        crossorigin="anonymous"></script>--%>


<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/home"><spring:message code="navbar.brand"/></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item active">
                        <a class="nav-link" aria-current="page" href="/home"><spring:message code="navbar.home"/></a>
                    </li>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li class="nav-item">
                            <a class="nav-link" href="/info/active"><spring:message code="navbar.active_booking"/></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li class="nav-item">
                            <a class="nav-link" href="/info/history"><spring:message code="navbar.rentals"/></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li class="nav-item">
                            <a class="nav-link" href="/user"><spring:message code="navbar.account"/></a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/manageCars"><spring:message code="navbar.manageCars"/></a>
                        </li>
                    </sec:authorize>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/manageUsers"><spring:message code="navbar.manageUsers"/></a>
                        </li>
                    </sec:authorize>

                    <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="/availableCars"><spring:message code="available_cars"/></a>
                        </li>
                    </sec:authorize>

                    <%--                    <li class="nav-item">--%>
                    <%--                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                    <%--                    </li>--%>
                </ul>
                <%--                <c:if test="${pageContext.request.userPrincipal.name != null}">--%>
                <%--                    <button type="button" class="btn btn-info">Welcome: ${pageContext.request.userPrincipal.name}</button>--%>
                <%--                <form class="d-flex" method="get" action="/logout">--%>
                <%--&lt;%&ndash;                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">&ndash;%&gt;--%>
                <%--                    <button class="btn btn-outline-info" type="submit"><spring:message code="navbar.logout"/></button>--%>
                <%--                </form>--%>
                <%--                </c:if>--%>

                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>

                <form action="/logout" method="post" id="logoutForm">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>

                <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_WORKER', 'ROLE_ADMIN')">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <button disabled type="button"
                                class="btn btn-info">${pageContext.request.userPrincipal.name}</button>
                        <%--                    <span class="badge badge-info">${pageContext.request.userPrincipal.name}</span>--%>
                        <%--                    <form class="d-flex" method="get" action="/logout">--%>
                        <%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
                        <a href="javascript:formSubmit()" class="btn btn-outline-info"><spring:message
                                code="navbar.logout"/></a>
                        <%--                    </form>--%>
                    </c:if>
                </sec:authorize>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <sec:authorize access="isAnonymous()">
                        <%--                    <span class="badge badge-info">${pageContext.request.userPrincipal.name}</span>--%>
                        <%--                    <form class="d-flex" method="get" action="/logout">--%>
                        <%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
                        <a href="/login" class="btn btn-outline-info"><spring:message code="login"/></a>
                        <%--                    </form>--%>
                    </sec:authorize>
                </c:if>

                <form class="d-flex text-light align-middle" action="" id="langForm" method="get">
                    <select class="form-select bg-dark text-light" aria-label="Default select example" name="lang"
                            size="1" onchange="form.submit()">
                        <option disabled selected class="text-light"><spring:message code="language"/></option>
                        <option value="de" class="text-light">DE</option>
                        <option value="en" class="text-light">EN</option>
                        <option value="pl" class="text-light">PL</option>
                    </select>
                </form>

            </div>

        </div>
    </nav>
</header>


</body>
</html>
