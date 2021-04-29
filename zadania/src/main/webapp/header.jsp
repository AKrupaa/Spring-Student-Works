<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 25.10.2020
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title.header"/></title>
    <form class="content" id="langForm" action="" method="get">
        <span>
            <select size="1" name="lang" onchange="form.submit()">
            <option value="pl">PL</option>
            <option value="en">EN</option>
            <option value="de">DE</option>
        </select>
        </span>
    </form>
</head>
<body>
<div class="header">
    HEADER
</div>
</body>
</html>