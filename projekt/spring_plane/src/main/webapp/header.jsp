<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<head>
    <!-- Bootstrap core CSS -->
    <%--    <link href="//getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="<c:url value="/resources/css/product.css"/>" rel="stylesheet">
</head>

<header class="site-header sticky-top py-1">
    <%--    justify-content-start/end--%>
    <%--    <nav class="container d-flex flex-column flex-md-row justify-content-between">--%>
    <nav class="container d-flex">
        <div class="d-flex flex-row bd-highlight flex-grow-1">
            <a class="py-2" href="/" aria-label="Product">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor"
                     stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mx-auto" role="img"
                     viewBox="0 0 24 24"><title>Product</title>
                    <circle cx="12" cy="12" r="10"/>
                    <path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/>
                </svg>
            </a>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <a class="py-2 d-none d-md-inline-block p-2" href="/pending-tickets">Pending
                    tickets</a>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <a class="py-2 d-none d-md-inline-block p-2" href="/your-tickets">Your
                    tickets</a>
            </sec:authorize>

            <sec:authorize access="hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')">
                <a class="py-2 d-none d-md-inline-block p-2" href="/queue">Working
                    space</a>
            </sec:authorize>
            <%--        <a class="py-2 d-none d-md-inline-block" href="#">Enterprise</a>--%>
            <%--        <a class="py-2 d-none d-md-inline-block" href="#">Support</a>--%>
            <%--        <a class="py-2 d-none d-md-inline-block" href="#">Pricing</a>--%>
            <%--        <a class="py-2 d-none d-md-inline-block" href="#">Cart</a>--%>


        </div>

        <div class="d-flex">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        ADMIN PANEL
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                        <li><a href="/userRole" class="dropdown-item text-dark">USER ROLE</a></li>
                        <li><a href="/manageUsers" class="dropdown-item text-dark">MANAGE USERS</a></li>
                        <li><a href="/airplane" class="dropdown-item text-dark">MANAGE AIRPLANES</a></li>
                    </ul>
                </div>
            </sec:authorize>

            <div class="dropdown ">
                <form action="" id="langForm" method="get">
                    <select class="form-select dropdown-toggle" id="dropdownMenuButton" name="lang"
                            data-bs-toggle="dropdown" aria-expanded="false"
                            size="1" onchange="form.submit()">
                        <option class="dropdown-item" disabled selected><spring:message code="language"/></option>
                        <option class="dropdown-item" value="de">DE</option>
                        <option class="dropdown-item" value="en">EN</option>
                        <option class="dropdown-item" value="pl">PL</option>
                    </select>
                </form>
            </div>

            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <form action="/logout" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>


            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                            data-bs-toggle="dropdown" aria-expanded="false">
                            ${pageContext.request.userPrincipal.name}
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a href="javascript:formSubmit()" class="dropdown-item text-dark">Logout</a></li>
                    </ul>
                </div>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <button class="btn btn-primary" id="linkcolor" type="button">
                    <a href="/login">Log in</a>
                </button>
                <button class="btn btn-secondary" id="linkcolor" type="button">
                    <a href="/register">Sign up</a>
                </button>
            </c:if>
        </div>
    </nav>
</header>