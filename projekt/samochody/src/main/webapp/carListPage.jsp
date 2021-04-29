<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 15.01.2021
  Time: 17:32
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

        <c:if test="${!empty modelCarList}">

<%--            <h3>Available cars</h3>--%>
            <h3><spring:message code="available_cars"/></h3>

            <table class="table table-sm">
                <thead class="thead-light">
                <tr class="table-light">
                        <%--                    <th scope="col">id</th>--%>
<%--                    <th scope="col">Car name</th>--%>
                    <th scope="col"><spring:message code="car_name"/></th>
<%--                    <th scope="col">Car title</th>--%>
                    <th scope="col"><spring:message code="car_title"/></th>
<%--                    <th scope="col">Car description</th>--%>
                    <th scope="col"><spring:message code="car_description"/></th>
<%--                    <th scope="col">Car price</th>--%>
                    <th scope="col"><spring:message code="car_price"/></th>
<%--                    <th scope="col">Rent a car</th>--%>
                    <th scope="col"><spring:message code="rent_a_car"/></th>
                        <%--                        <c:if test="${!empty selectedCarTypeList}">--%>
                        <%--                            <th scope="col">Car Types</th>--%>
                        <%--                        </c:if>--%>
                        <%--                    <th scope="col">edit</th>--%>
                        <%--                    <th scope="col">delete</th>--%>
                        <%--                    <th scope="col">rented</th>--%>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${modelCarList}" var="car" varStatus="status">

                    <tr class="table-light">

                        <td>${car.name}</td>
                        <td>${car.title}</td>
                        <td>${car.description}</td>
                        <td>${car.price}</td>

<%--                        <td><a href="/info/purchase/${car.id}" class="btn btn-primary">Rent now!</a></td>--%>
                        <td><a href="/info/purchase/${car.id}" class="btn btn-primary"><spring:message code="rent_now"/></a></td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </c:if>

        <c:if test="${empty modelCarList}">
<%--            <h2>There is not car left</h2>--%>
            <h2><spring:message code="t_i_n_c_l"/></h2>
        </c:if>

    </div>
</main>
</body>
</html>
