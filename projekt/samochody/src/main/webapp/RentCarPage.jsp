<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 03.01.2021
  Time: 01:29
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

        <form action="/purchase/"></form>
        <form:form action="/purchase/${modelCar.id}">
            <c:if test="${modelCar.rented == true}">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="alert alert-info text-center"><spring:message code="car_rented_"/></h1>
                    </div>
                </div>
            </c:if>

            <div class="row">

                <div class="col">
                        <%--        <div class="card mb-3">--%>
                        <%--                    <form:hidden path="id"/>--%>
                        <%--                    <form:hidden path="rentalStartDateAndTime"/>--%>
                        <%--                    <form:hidden path="rentalEndDateAndTime"/>--%>
                        <%--                    <form:hidden path="costsOfRental"/>--%>
                        <%--                    <form:hidden path="completed"/>--%>

                    <img class="card-img-top" src="${modelCar.sourceImage}"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${modelCar.title}</h5>
                        <p class="card-text">${modelCar.description}</p>
                            <%--                        <p class="card-text"><small class="text-muted">Is rented? ${modelCar.rented}</small></p>--%>
                            <%--                        <a href="#" class="card-link">Card link</a>--%>
                        <a href="/home" class="btn bg-danger"><spring:message code="back"/></a>
                        <c:if test="${modelCar.rented == true}">
                            <button type="submit" class="btn bg-success" disabled><spring:message code="purchase"/></button>
                        </c:if>
                        <c:if test="${modelCar.rented == false}">
                            <button type="submit" class="btn bg-success"><spring:message code="purchase"/></button>
                        </c:if>
                    </div>
                </div>
            </div>

        </form:form>

    </div>
</main>
</body>
</html>
