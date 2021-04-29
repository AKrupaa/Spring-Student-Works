<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 20.10.2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title.userAddressView"/></title>
</head>
<body>
<div class="content">

    <h1>Address View:</h1>

<%--     action - prowadzi do @RequestMapping(value = "/addUserAddress"--%>
    <form:form method="post" action="addUserAddress.html" modelAttribute="modelUserAddress">

        <table>
            <tr>
                <td><form:hidden path="id"/></td>
            </tr>
            <tr>
                <td><form:label path="country"><spring:message code="label.country"/></form:label></td>
                <td><form:input path="country"/></td>
                <td><form:errors path="country"/></td>
            </tr>
            <tr>
                <td><form:label path="city"><spring:message code="label.city"/></form:label></td>
                <td><form:input path="city"/></td>
                <td><form:errors path="city"/></td>
            </tr>
            <tr>
                <td><form:label path="state"><spring:message code="label.state"/></form:label></td>
                <td><form:input path="state"/></td>
                <td><form:errors path="state"/></td>
            </tr>
            <tr>
                <td><form:label path="address"><spring:message code="label.address"/></form:label></td>
                <td><form:input path="address"/></td>
                <td><form:errors path="address"/></td>
            </tr>
            <tr>
                <td><form:label path="zipCode"><spring:message code="label.zipCode"/></form:label></td>
                <td><form:input path="zipCode"/></td>
                <td><form:errors path="zipCode"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${modelUserAddress.id == 0}">
                        <input type="submit" value=<spring:message code="submit.addUserAddress"/>>
                    </c:if>
                    <c:if test="${modelUserAddress.id != 0}">
                        <input type="submit" value=<spring:message code="submit.editUserAddress"/>>
                    </c:if>
                </td>
            </tr>
        </table>


        <%--        show list of addresses --%>
        <h3><spring:message code="label.userAddressList"/></h3>
        <c:if test="${!empty modelListOfUsersAddresses}">
            <table class="data">
                <tr>
                    <th><spring:message code="label.country"/></th>
                    <th><spring:message code="label.city"/></th>
                    <th><spring:message code="label.state"/></th>
                    <th><spring:message code="label.address"/></th>
                    <th><spring:message code="label.zipCode"/></th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${modelListOfUsersAddresses}" var="listOfAddresses">
                    <tr>
                        <td>${listOfAddresses.country}</td>
                        <td>${listOfAddresses.city}</td>
                        <td>${listOfAddresses.state}</td>
                        <td>${listOfAddresses.address}</td>
                        <td>${listOfAddresses.zipCode}</td>
                        <td><a href="deleteAddress/${listOfAddresses.id}.html">delete</a></td>
                        <td><a href="showUserAddress/${listOfAddresses.id}.html">edit/show</a></td>
<%--                        <td><a href="/${listOfAddresses.id}.html">edit/show</a></td>--%>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form:form>

</div>
</body>
</html>
