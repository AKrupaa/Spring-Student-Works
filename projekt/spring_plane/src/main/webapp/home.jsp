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

    <c:if test="${!empty booked}">
        <h2 class="alert alert-success">${booked}</h2>
    </c:if>

    <c:if test="${!empty flights}">
    <table class="table mt-3">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Departure</th>
            <th scope="col">Arrival</th>
            <th scope="col">From</th>
            <th scope="col">To</th>
            <th scope="col">View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${flights}" var="flight" varStatus="status">
        <tr>
            <th scope="row">${status.index}</th>
            <td>${flight.departure}</td>
            <td>${flight.arrival}</td>
            <td>${flight.source}</td>
            <td>${flight.destination}</td>
            <td><a href="/buy/ticket/on/flight/${flight.id}">Check</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    </c:if>
</main>

</body>
</html>

