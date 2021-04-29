<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 24.11.2020
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td height="80" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td height="200"><tiles:insertAttribute name="menu" /></td>
        <td width="350"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>
