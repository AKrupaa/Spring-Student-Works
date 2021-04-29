<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 24.11.2020
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 10px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>

<body onload='document.loginForm.username.focus();'>
<div class="content">
    <h3><spring:message code="h3.login.LoginPage"/></h3>
    <div id="login-box">

        <h3><spring:message code="h3.loginWithUserAndPass"/></h3>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <form name='loginForm' action="<c:url value='/login'/>" method='POST'>

            <table>
                <tr>
                    <td><spring:message code="td.appUser"/></td>
                    <td><input type='text' name='login' value=''></td>
                </tr>
                <tr>
                    <td><spring:message code="td.appPassword"/></td>
                    <td><input type='password' name='password'/></td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit" value="submit"/></td>
                </tr>
            </table>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>
</body>
</html>
