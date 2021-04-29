<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Pending</title>
</head>
<body>
<main class="container">
    <c:if test="${!empty tickets}">
        <table class="table mt-3">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">From</th>
                <th scope="col">To</th>
                <th scope="col">Departure</th>
                <th scope="col">Arrival</th>
                <th scope="col">Price</th>
                <th scope="col">Pending?</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tickets}" var="ticket" varStatus="status">
                <tr>
                    <th scope="row">${status.index}</th>
                    <td>${ticket.airplane.source}</td>
                    <td>${ticket.airplane.destination}</td>
                    <td>${ticket.airplane.departure}</td>
                    <td>${ticket.airplane.arrival}</td>
                    <td>${ticket.price}</td>
                    <td>YES</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>

    <c:if test="${empty tickets}">
        <h2 class="mt-5">You have no pending tickets!</h2>
    </c:if>
</main>

</body>
</html>
