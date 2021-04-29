<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 02.01.2021
  Time: 16:20
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
<%--        <h3>Manage car type</h3>--%>

        <form:form modelAttribute="modelCarType" method="post" action="/add/carType">
            <h3><spring:message code="m_c_t"/></h3>

            <form:hidden path="id"/>
            <div class="form-group row">
                <form:label path="description" for="inputDescription"
                            class="col-sm-2 col-form-label"><spring:message code="i_c_t"/></form:label>
                <div class="col-sm-10">
                    <form:input path="description" type="text" class="form-control" id="inputDescription"
                                placeholder="car type description"/>
                    <form:errors path="description" class="form-control bg-dark text-warning" id="inputDescription"/>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10">
                    <c:if test="${modelCarType.id == 0}">
                        <button type="submit" class="btn btn-primary"><spring:message code="a_n_c_t"/></button>
                    </c:if>

                    <c:if test="${modelCarType.id != 0}">
                        <button type="submit" class="btn btn-primary"><spring:message code="e_c_t"/></button>
                    </c:if>
                </div>
            </div>

            <h3>Car type list</h3>
            <c:if test="${!empty modelCarTypeList}">

                <table class="table table-sm">
                    <thead class="thead-light">
                    <tr class="table-light">
                        <th scope="col"><spring:message code="id"/></th>
                        <th scope="col"><spring:message code="description"/></th>
                        <th scope="col"><spring:message code="edit"/></th>
                        <th scope="col"><spring:message code="delete"/></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${modelCarTypeList}" var="car" varStatus="status">

                        <tr class="table-light">
                            <td>${car.id}</td>
                            <td>${car.description}</td>
                            <td><a href="/edit/carType/${car.id}.html"><spring:message code="edit"/></a></td>
                            <td><a href="/delete/carType/${car.id}.html"><spring:message code="delete"/></a></td>
                        </tr>

                    </c:forEach>

                    </tbody>
                </table>

            </c:if>

        </form:form>

        <h3><a href="/manageCars"><spring:message code="navbar.manageCars"/></a></h3>

    </div>
</main>
</body>
</html>
