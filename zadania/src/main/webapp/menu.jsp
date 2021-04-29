<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title><spring:message code="title.menu"/></title>
</head>
<body>
<div class="sidenav">
    <a href="/.html"><spring:message code="href.mainpage"/></a>
    <a href="/appUsers.html"><spring:message code="href.appUsers"/></a>
    <a href="/userAddressView.html"><spring:message code="href.address"/></a>
    <a href="/exampleOne.html"><spring:message code="href.exampleOne"/></a>
    <a href="/exampleTwo.html"><spring:message code="href.exampleTwo"/></a>
    <a href="/exampleThree.html"><spring:message code="href.exampleThree"/></a>

    <%--    <c:if test="${pageContext.request.userPrincipal.name != null}">--%>
    <%--        <p>--%>
    <%--            <spring:message code="label.welcome"/>: ${pageContext.request.userPrincipal.name}--%>
    <%--            <a href="/logout">Logout</a>--%>
    <%--        </p>--%>
    <%--    </c:if>--%>

    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

    <!-- csrf for log out-->
    <form action="/logout" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <br/>
    <%--    <div>--%>

    <c:if test="${pageContext.request.userPrincipal.name != null}">


        <a><spring:message code="label.welcome"/> : ${pageContext.request.userPrincipal.name}  </a>
        <a href="javascript:formSubmit()"> Logout</a>

    </c:if>
    <%--    </div>--%>
</div>
</body>
</html>