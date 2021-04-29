<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 30.12.2020
  Time: 12:07
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

        <%--        <form action="/add/user"></form>--%>
        <%--        <form action="/add/userrrr"></form>--%>

        <form:form method="post" action="/add/userrrr" modelAttribute="modelUserCore">
            <form:hidden path="id"/>
<%--            <form:hidden path="historyDomains" />--%>
            <div class="form-group row">
                <form:label path="email" for="inputEmail" class="col-sm-2 col-form-label"><spring:message code="email"/></form:label>
                <div class="col-sm-10">
                    <form:input path="email" type="text" class="form-control" id="inputEmail" placeholder="email"/>
                    <form:errors path="email" type="text" class="form-control" id="inputEmail" placeholder="email"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="userDomain.firstName" for="inputFirstName"
                            class="col-sm-2 col-form-label"><spring:message code="firstname"/></form:label>
                <div class="col-sm-10">
                    <form:input path="userDomain.firstName" type="text" class="form-control" id="inputFirstName"
                                placeholder="first name"/>
                    <form:errors path="userDomain.firstName" type="text" class="form-control" id="inputFirstName"
                                 placeholder="first name"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="userDomain.lastName" for="inputLastName"
                            class="col-sm-2 col-form-label"><spring:message code="lastname"/></form:label>
                <div class="col-sm-10">
                    <form:input path="userDomain.lastName" type="text" class="form-control" id="inputLastName"
                                placeholder="last name"/>
                    <form:errors path="userDomain.lastName" type="text" class="form-control" id="inputLastName"
                                 placeholder="last name"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="userDomain.telephone" for="inputTelephone"
                            class="col-sm-2 col-form-label"><spring:message code="telephone"/></form:label>
                <div class="col-sm-10">
                    <form:input path="userDomain.telephone" type="text" class="form-control" id="inputTelephone"
                                placeholder="telephone"/>
                    <form:errors path="userDomain.telephone" type="text" class="form-control" id="inputTelephone"
                                 placeholder="telephone"/>
                </div>
            </div>


            <%--            <div class="form-group row">--%>
            <%--                <div class="col-sm-2">Checkbox</div>--%>
            <%--                <div class="col-sm-10">--%>
            <%--                    <div class="form-check">--%>
            <%--                        <form:checkbox path="rented" class="form-check-input" id="gridCheck1"/>--%>
            <%--                        <form:label path="rented" class="form-check-label" for="gridCheck1">--%>
            <%--                            Rented - leave it unchecked--%>
            <%--                        </form:label>--%>
            <%--                    </div>--%>
            <%--                </div>--%>
            <%--            </div>--%>
            <div class="form-group row">
                <div class="col-sm-10">
                    <c:if test="${modelUserCore.id == 0}">
                        <button type="submit" class="btn btn-primary"><spring:message code="add_new_user"/></button>
                    </c:if>

                    <c:if test="${modelUserCore.id != 0}">
                        <button type="submit" class="btn btn-primary"><spring:message code="edit_user"/></button>
                    </c:if>
                </div>
            </div>


            <h3><spring:message code="user_core_list"/></h3>
            <c:if test="${!empty modelUserCoreList}">

                <table class="table table-sm">
                    <thead class="thead-light">
                    <tr class="table-light">
                        <th scope="col"><spring:message code="id"/></th>
                        <th scope="col"><spring:message code="email"/></th>
                            <%--                        <th scope="col">user id</th>--%>
                        <th scope="col"><spring:message code="firstname"/></th>
                        <th scope="col"><spring:message code="lastname"/></th>
                        <th scope="col"><spring:message code="telephone"/></th>
                            <%--                        <th scope="col">source</th>--%>
                            <%--                        <th scope="col">rented</th>--%>
                        <th scope="col"><spring:message code="edit"/></th>
                        <th scope="col"><spring:message code="delete"/></th>
                            <%--                    <th scope="col">rented</th>--%>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${modelUserCoreList}" var="user" varStatus="status">

                        <%--                        <fmt:parseNumber var = "id_value" type = "number" value = "${samochod.data.id}" />--%>
                        <%--                        <c:out value = "${id_value}" />--%>

                        <%--                        <c:set var="idAsString">${samochod.id}</c:set>--%>
                        <%--                        <c:out value = "${idAsString}" />&ndash;%&gt;--%>
                        <%--                        ${''.concat(samochod.id)}--%>
                        <%--                        <c:forEach items="${modelCarList}" var="item" varStatus="status" >--%>
                        <%--                            <form:input path="itemList[${status.index}].name" />--%>
                        <%--                        </c:forEach>--%>
                        <tr class="table-light">
                                <%--                            <c:set var="idAsString">${samochod.id}</c:set>--%>
                                <%--                        <c:out value="${samochod.myHashtable[idAsString]}" />--%>
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                                <%--                            <td>${user.userDomain.id}</td>--%>
                            <td>${user.userDomain.firstName}</td>
                            <td>${user.userDomain.lastName}</td>
                            <td>${user.userDomain.telephone}</td>
                                <%--                            <td>${car.sourceImage}</td>--%>
                                <%--                            <td>${car.rented}</td>--%>
                                <%--                                    /delete/user/{userID}"--%>
                            <td><a href="/edit/user/${user.id}.html"><spring:message code="edit"/></a></td>
                            <td><a href="/delete/user/${user.id}.html"><spring:message code="delete"/></a></td>

                        </tr>

                    </c:forEach>

                    </tbody>
                </table>

            </c:if>


        </form:form>


        <br>
        <%--        ostatni element--%>
    </div>
</main>
</body>
</html>
