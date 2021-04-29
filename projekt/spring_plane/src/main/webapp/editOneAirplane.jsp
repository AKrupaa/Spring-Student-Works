<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 18:03
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
    <form:form class="form-horizontal" method="post" action="/update/airplane" modelAttribute="airplane">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Edit ${airplane.name}</h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">


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

            <div class="form-group">
                <label for="source" class="cols-sm-2 control-label">Source</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <form:input path="source" type="text" class="form-control" name="source" id="source"
                                    placeholder="Enter your last name"/>
                        <form:errors path="source"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="destination" class="cols-sm-2 control-label">Destination</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                        <form:input path="destination" type="text" class="form-control" name="destination" id="destination"
                                    placeholder="Enter your Email"/>
                        <form:errors path="destination"/>
                    </div>
                </div>
            </div>

            <div class="form-group ">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button mt-3">Edit</button>
            </div>

            </form:form>
        </div>
    </div>
</main>

</body>
</html>
