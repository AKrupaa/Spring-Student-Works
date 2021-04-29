<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 04.01.2021
  Time: 12:48
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

        <c:if test="${!empty modelHistoryList}">

<%--            <h3>Your history</h3>--%>
            <h3><spring:message code="y_history"/></h3>

            <table class="table table-sm">
                <thead class="thead-light">
                <tr class="table-light">
                        <%--                    <th scope="col">id</th>--%>
                    <th scope="col"><spring:message code="car_name"/></th>
<%--                    <th scope="col">Rental start date and time</th>--%>
                    <th scope="col"><spring:message code="Rental_s_d_a_t"/></th>
<%--                    <th scope="col">Rental end date and time</th>--%>
                    <th scope="col"><spring:message code="Rental_e_d_a_t"/></th>
<%--                    <th scope="col">Rental total costs</th>--%>
                    <th scope="col"><spring:message code="Rental_total"/></th>
<%--                    <th scope="col">generate pdf</th>--%>
                    <th scope="col"><spring:message code="generate_pdf"/></th>
                        <%--                        <c:if test="${!empty selectedCarTypeList}">--%>
                        <%--                            <th scope="col">Car Types</th>--%>
                        <%--                        </c:if>--%>
                        <%--                    <th scope="col">edit</th>--%>
                        <%--                    <th scope="col">delete</th>--%>
                        <%--                    <th scope="col">rented</th>--%>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${modelHistoryList}" var="history" varStatus="status">

                    <tr class="table-light">

                        <td>${history.carDomain.name}</td>
                        <td>${history.rentalStartDateAndTimeString}</td>
                        <td>${history.rentalEndDateAndTimeString}</td>
                        <td>${history.costsOfRental}</td>
<%--                        /generatePdf-{userCoreID}-{historyID}--%>
<%--                        <td><a href="/generate/pdf/${history.id}">Get as .pdf</a></td>--%>
                        <td><a href="/generate/pdf/${history.id}"><spring:message code="get_as_pdf"/></a></td>
                            <%--                    <td>${car.id}</td>--%>

                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </c:if>

        <c:if test="${empty modelHistoryList}">
            <h2><spring:message code="you_do_not_rent_any_car_yet"/></h2>
        </c:if>

    </div>
    <br>
    <br>
    <br>

</main>
</body>
</html>
