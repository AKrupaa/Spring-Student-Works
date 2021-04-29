<%@ page import="pl.arkadiusz.domain.HistoryDomain" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 03.01.2021
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="bg-dark">
<main class="flex-shrink-0 text-white">
    <div class="container">
        <br>
        <br>
        <br>

        <c:if test="${LastRentalModel != null}">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="alert alert-info text-center"><spring:message code="last_rent"/> ${LastRentalModel}</h1>
                </div>
            </div>
        </c:if>

        <c:if test="${!empty modelBooking}">

            <h3><spring:message code="active_bookings"/></h3>

            <table class="table table-sm">
                <thead class="thead-light">
                <tr class="table-light">
<%--                    <th scope="col">id</th>--%>
                    <th scope="col"><spring:message code="car_name"/></th>
                    <th scope="col"><spring:message code="Rental_s_d_a_t"/></th>
                    <th scope="col"><spring:message code="finish_your_rental"/></th>
                        <%--                        <c:if test="${!empty selectedCarTypeList}">--%>
                        <%--                            <th scope="col">Car Types</th>--%>
                        <%--                        </c:if>--%>
<%--                    <th scope="col">edit</th>--%>
<%--                    <th scope="col">delete</th>--%>
                        <%--                    <th scope="col">rented</th>--%>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${modelBooking}" var="book" varStatus="status">

                <tr class="table-light">

                    <td>${book.carDomain.name}</td>
                    <td>${book.rentalStartDateAndTimeString}</td>
                    <td><a href="/rental/end/${book.id}"><spring:message code="finish_the_rental"/></a></td>
<%--                    <td>${car.id}</td>--%>

                </tr>

                </c:forEach>

                </tbody>
            </table>
        </c:if>

        <c:if test="${empty modelBooking}">
            <h2><spring:message code="you_do_not_rent_any_car_yet"/></h2>
        </c:if>

        <%--        <form:form >--%>
        <%--        </form:form>--%>

    </div>
    <br>
    <br>
    <br>
</main>
</body>
</html>
