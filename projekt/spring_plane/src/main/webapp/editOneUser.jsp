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
    <form:form class="form-horizontal" method="post" action="/user/edit" modelAttribute="user">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Edit ${user.firstName}</h1>
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
                        <form:input path="firstName" type="text" class="form-control" name="name" id="name"
                                    placeholder="Enter your Name"/>
                        <form:errors path="firstName"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="lastName" class="cols-sm-2 control-label">Last Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <form:input path="lastName" type="text" class="form-control" name="lastName" id="lastName"
                                    placeholder="Enter your last name"/>
                        <form:errors path="lastName"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="cols-sm-2 control-label">Email</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                        <form:input path="email" type="text" class="form-control" name="email" id="email"
                                    placeholder="Enter your Email"/>
                        <form:errors path="email"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="username" class="cols-sm-2 control-label">Login</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                        <form:input path="login" type="text" class="form-control" name="username" id="username"
                                    placeholder="Enter your Username"/>
                        <form:errors path="login"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="cols-sm-2 control-label">Present user roles</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                        <c:forEach items="${userRoles}" var="oneRole">
                            <p class="form-control">${oneRole.role}</p>
                        </c:forEach>
                    </div>
                </div>
            </div>


            <form:label path="userRoles" for="inputUserRoles"
                        class="col-sm-2 col-form-label">Roles</form:label>

            <form:select path="userRoles" class="form-control" id="inputUserRoles"
                         multiple="true">

                <form:options items="${roleList}" itemValue="id" itemLabel="role"/>

            </form:select>
            <form:errors path="userRoles" type="text" class="form-control bg-dark text-warning" id="inputUserRoles"/>


                <%--            <td><form:label path="appUserRole"><spring:message code="label.role"/></form:label></td>--%>
                <%--            <td><form:select path="appUserRole" multiple="true">--%>
                <%--                <form:options items="${appUserRoleList}" itemValue="id" itemLabel="role"/>--%>
                <%--            </form:select></td>--%>
                <%--            <td><form:errors path="appUserRole"/></td>--%>


            <div class="form-group ">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Edit</button>
            </div>

            </form:form>
        </div>
    </div>
</main>

</body>
</html>
