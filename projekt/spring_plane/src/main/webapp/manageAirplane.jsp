<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 19:56
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
    <%--    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">--%>
    <%--    <link rel="stylesheet" href="/resources/demos/style.css">--%>
    <%--    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
    <%--    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>--%>
    <%--    <script>--%>
    <%--        $(function () {--%>
    <%--            $("#datepicker").datepicker();--%>
    <%--        });--%>
    <%--    </script>--%>
    <%--    <script>--%>
    <%--        $(function () {--%>
    <%--            $("#datepicker1").datepicker();--%>
    <%--        });--%>
    <%--    </script>--%>
</head>
<body>
<main class="container">

    <c:if test="${!empty warning}">
        <h2 class="alert alert-info">${warning}</h2>
    </c:if>

    <c:if test="${!empty flight}">
        <h2 class="alert alert-info">${flight}</h2>
    </c:if>

    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Add Airplane</h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" method="post" action="/airplane" modelAttribute="airplane">
                <%--                <p>Date: <input type="text" id="datepicker"></p>--%>
                <form:hidden path="id"/>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="name" type="text" class="form-control" name="name" id="name"
                                        placeholder="Enter your Name"/>
                            <form:errors path="name"/>
                        </div>
                    </div>
                </div>

                <%--                <form:hidden path="departure"/>--%>
                <div class="form-group">
                    <label for="departure" class="cols-sm-2 control-label">Departure Date</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="departure" type="text" class="form-control" name="departure"
                            />
                                <%--                            <fmt:formatDate value="${bean.date}" pattern="yyyy-MM-dd HH:mm:ss" />--%>
                            <form:errors path="departure"/>
                        </div>
                    </div>
                </div>

                <%--                <form:hidden path="arrival"/>--%>
                <div class="form-group">
                    <label for="arrival" class="cols-sm-2 control-label">Arrival Date</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <a>
                                    <form:input path="arrival" type="text" class="form-control" name="arrival"
                                    />
                                    <form:errors path="arrival"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="source" class="cols-sm-2 control-label">Source</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <form:input path="source" type="text" class="form-control" name="source" id="source"
                                        placeholder="From?"/>
                            <form:errors path="source"/>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label for="destination" class="cols-sm-2 control-label">destination</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="destination" type="text" class="form-control" name="destination"
                                        id="destination" placeholder="To?"/>
                            <form:errors path="destination"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button mt-3">Insert new plane
                    </button>
                </div>

            </form:form>
        </div>
    </div>


    <c:if test="${!empty airplanes}">
        <p class="mt-5 mb-3">Available airplanes:</p>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Departure Date</th>
                <th scope="col">Arrival Date</th>
                <th scope="col">From</th>
                <th scope="col">Destination</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${airplanes}" var="airplane" varStatus="status">
                <tr>
                    <th scope="row">${status.index}</th>
                    <td>${airplane.id}</td>
                    <td>${airplane.name}</td>
                    <td>${airplane.departure}</td>
                    <td>${airplane.arrival}</td>
                    <td>${airplane.source}</td>
                    <td>${airplane.destination}</td>

                    <td><a href="/edit/airplane/${airplane.id}">edit</a></td>
                    <td><a href="/delete/airplane/${airplane.id}">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:if>
</main>

</body>
</html>
