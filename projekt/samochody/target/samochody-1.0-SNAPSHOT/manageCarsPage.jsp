<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 29.12.2020
  Time: 11:44
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
<%--        <h3><a href="/manageCarType">Manage car type</a></h3>--%>
        <h3><a href="/manageCarType"><spring:message code="menu.manage_car_type"/></a></h3>
        <c:if test="${modelDelete != null}">
            <div class="row">
                <div class="col-md-12">
<%--                    <h1 class="alert alert-info text-center">Cannot Delete (is still referenced)</h1>--%>
                    <h1 class="alert alert-info text-center"><spring:message code="there_is_reference"/></h1>
                </div>
            </div>
        </c:if>
        <form:form method="post" action="/add/car" modelAttribute="modelCar">
            <h3>Manage car</h3>
            <form:hidden path="id"/>
            <div class="form-group row">
                <form:label path="name" for="inputCarName" class="col-sm-2 col-form-label"><spring:message code="car_name"/></form:label>
                <div class="col-sm-10">
                    <form:input path="name" type="text" class="form-control" id="inputCarName" placeholder="car name"/>
                    <form:errors path="name" class="form-control bg-dark text-warning" id="inputCarName"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="title" for="inputCarTitle" class="col-sm-2 col-form-label"><spring:message code="car_title"/></form:label>
                <div class="col-sm-10">
                    <form:input path="title" type="text" class="form-control" id="inputCarTitle"
                                placeholder="car title"/>
                    <form:errors path="title" type="text" class="form-control bg-dark text-warning" id="inputCarTitle"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="description" for="inputCarDesc"
                            class="col-sm-2 col-form-label"><spring:message code="car_description"/></form:label>
                <div class="col-sm-10">
                    <form:input path="description" type="text" class="form-control" id="inputCarDesc"
                                placeholder="car description"/>
                    <form:errors path="description" type="text" class="form-control bg-dark text-warning"
                                 id="inputCarDesc"/>
                </div>
            </div>

            <div class="form-group row">
                <form:label path="price" for="inputPrice"
                            class="col-sm-2 col-form-label"><spring:message code="car_price_per_minute"/></form:label>
                <div class="col-sm-10">
                    <form:input path="price" type="text" class="form-control" id="inputPrice"
                                placeholder="car price per minute"/>
                    <form:errors path="price" type="text" class="form-control bg-dark text-error"
                                 id="inputPrice"/>
                </div>
            </div>


            <div class="form-group row">
                <c:if test="${!empty selectedCarTypeList}">
                    <label for="inputCarTypeList"
                           class="col-sm-2 col-form-label bg-warning"><spring:message code="t_o_s_c"/> ${modelCar.name}</label>
                    <textarea id="inputCarTypeList" class="form-control" rows="4" readonly>
                    <c:forEach items="${selectedCarTypeList}" var="selectedCarType">
                        ${selectedCarType.description}
                    </c:forEach>
                     </textarea>
                </c:if>


                <form:label path="carTypes" for="inputCarTypes"
                            class="col-sm-2 col-form-label"><spring:message code="m_s_c_t"/></form:label>

                <form:select path="carTypes" class="form-control" id="inputCarTypes"
                             multiple="true">

                    <form:options items="${modelCarTypesList}" itemValue="id" itemLabel="description"/>

                </form:select>
                <form:errors path="carTypes" type="text" class="form-control bg-dark text-warning" id="inputCarTypes"/>

            </div>


            <%--            <div class="form-group">--%>
            <%--                <label for="exampleFormControlSelect2">Example multiple select</label>--%>
            <%--                <select multiple class="form-control" id="exampleFormControlSelect2">--%>
            <%--                    <option>1</option>--%>
            <%--                    <option>2</option>--%>
            <%--                    <option>3</option>--%>
            <%--                    <option>4</option>--%>
            <%--                    <option>5</option>--%>
            <%--                </select>--%>
            <%--            </div>--%>


            <div class="form-group row">
                <form:label path="sourceImage" for="inputCarSourceImage"
                            class="col-sm-2 col-form-label"><spring:message code="c_s_i"/></form:label>
                <div class="col-sm-10">
                    <form:input path="sourceImage" type="text" class="form-control" id="inputCarSourceImage"
                                placeholder="car source image"/>
                    <form:errors path="sourceImage" type="text" class="form-control bg-dark text-warning"
                                 id="inputCarSourceImage"/>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-2">Checkbox</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <form:checkbox path="rented" class="form-check-input" id="gridCheck1"/>
                        <form:errors path="rented" class="form-control bg-dark text-warning" for="gridCheck1"/>
                        <form:label path="rented" class="form-check-label" for="gridCheck1">
                            <spring:message code="r_l_i_u"/>
                        </form:label>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <c:if test="${modelCar.id == 0}">
                        <button type="submit" class="btn btn-primary"><spring:message code="add_new_car"/></button>
                    </c:if>

                    <c:if test="${modelCar.id != 0}">
                        <button type="submit" class="btn btn-primary"><spring:message code="save_changes"/></button>
                    </c:if>
                </div>
            </div>


            <h3>Car list</h3>
            <c:if test="${!empty modelCarList}">

                <table class="table table-sm">
                    <thead class="thead-light">
                    <tr class="table-light">
                        <th scope="col"><spring:message code="id"/></th>
                        <th scope="col"><spring:message code="car_name"/></th>
                        <th scope="col"><spring:message code="car_title"/></th>
                        <th scope="col"><spring:message code="car_description"/></th>
                        <th scope="col"><spring:message code="car_price"/></th>
                        <th scope="col"><spring:message code="car_source"/></th>
                        <th scope="col"><spring:message code="car_rented"/></th>
                            <%--                        <c:if test="${!empty selectedCarTypeList}">--%>
                            <%--                            <th scope="col">Car Types</th>--%>
                            <%--                        </c:if>--%>
                        <th scope="col"><spring:message code="edit"/></th>
                        <th scope="col"><spring:message code="delete"/></th>
                            <%--                    <th scope="col">rented</th>--%>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${modelCarList}" var="car" varStatus="status">

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
                            <td>${car.id}</td>
                            <td>${car.name}</td>
                            <td>${car.title}</td>
                            <td>${car.description}</td>
                            <td>${car.price}</td>
                            <td>${car.sourceImage}</td>
                            <td>${car.rented}</td>
                                <%--                            <c:if test="${!empty selectedCarTypeList}">--%>
                                <%--                                <td>--%>
                                <%--                                    <c:forEach items="${selectedCarTypeList}" var="selectedCarType" varStatus="status">--%>
                                <%--&lt;%&ndash;                                        <c:if test="${status.index < status.end}">&ndash;%&gt;--%>
                                <%--                                            ${selectedCarType.description},--%>
                                <%--&lt;%&ndash;                                        </c:if>&ndash;%&gt;--%>

                                <%--&lt;%&ndash;                                        <c:if test="${status.last}">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;                                            ${selectedCarType.description}&ndash;%&gt;--%>
                                <%--&lt;%&ndash;                                        </c:if>&ndash;%&gt;--%>
                                <%--                                    </c:forEach>--%>
                                <%--                                </td>--%>
                                <%--                            </c:if>--%>
                            <td><a href="/edit/car/${car.id}.html"><spring:message code="edit"/>edit</a></td>
                            <td><a href="/delete/car/${car.id}.html"><spring:message code="delete"/>delete</a></td>

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
