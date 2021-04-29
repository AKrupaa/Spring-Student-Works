<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 06.02.2021
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<main class="container">
    <div class="row main mt-5">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Register</h1>
                <hr/>
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" method="post" action="/register" modelAttribute="user">

                <form:hidden path="id"/>

                <div class="form-group">
                    <label for="name" class="cols-sm-2 control-label">Your Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="firstName" type="text" class="form-control" name="name" id="name"
                                        placeholder="Enter your Name"/>
                            <form:errors path="firstName" class="form-control bg-dark text-warning"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="cols-sm-2 control-label">Your Last Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="lastName" type="text" class="form-control" name="lastName" id="lastName"
                                        placeholder="Enter your last name"/>
                            <form:errors path="lastName" class="form-control bg-dark text-warning"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Your Email</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input path="email" type="text" class="form-control" name="email" id="email"
                                        placeholder="Enter your Email"/>
                            <form:errors path="email" class="form-control bg-dark text-warning"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">Username</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <form:input path="login" type="text" class="form-control" name="username" id="username"
                                        placeholder="Enter your Username"/>
                            <form:errors path="login" class="form-control bg-dark text-warning"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="password" type="password" class="form-control" name="password"
                                        id="password" placeholder="Enter your Password"/>
                            <form:errors path="password" class="form-control bg-dark text-warning"/>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button mt-3">Register</button>
                </div>

            </form:form>
        </div>
    </div>
</main>

</body>
</html>

