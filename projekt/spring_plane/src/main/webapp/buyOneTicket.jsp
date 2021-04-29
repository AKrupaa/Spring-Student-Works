<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<main class="container">

    <c:if test="${not empty noTicketsLeft}}">
        <h1 class="alert alert-error mt-5">${noTicketsLeft}</h1>
    </c:if>

    <div class="card text-center">
        <div class="card-header">
            ${flight.name}
        </div>
        <div class="card-body">
            <c:if test="${not empty noTicketsLeft}">
            <h5 class="card-title"></h5>
            </c:if>
            <c:if test="${empty noTicketsLeft}">
                <h5 class="card-title">${ticket.price} zł</h5>
            </c:if>
            <p class="card-text">From ${flight.source} to ${flight.destination}</p>
            <p class="card-text">${flight.departure} || ${flight.arrival}</p>
            <c:if test="${empty noTicketsLeft}">
            <a href="/book/ticket/${ticket.id}/on/flight/${flight.id}" class="btn btn-primary">Book</a>
            </c:if>

            <c:if test="${not empty noTicketsLeft}">
                <a href="/" class="btn btn-primary">Back to home</a>
            </c:if>
        </div>
        <div class="card-footer text-muted">
            Ticket sales
        </div>
    </div>
</main>

</body>
</html>