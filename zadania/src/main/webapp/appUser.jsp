<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 19.10.2020
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title.AppUserPage"/></title>
    <!-- Captcha Google -->
    <script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
<div class="content">
    <h1>App user info:</h1>

    <form:form method="post" action="addAppUser.html" modelAttribute="appUser">

        <table>
            <tr>
                <td><form:hidden path="id"/></td>
            </tr>
            <tr>
                <td><form:label path="login"><spring:message code="label.login"/></form:label></td>
                <td><form:input path="login"/></td>
                <td><form:errors path="login"/></td>
            </tr>
            <tr>
                <td><form:label path="password"><spring:message code="label.password"/></form:label></td>
                <td><form:input path="password"/></td>
                <td><form:errors path="password"/></td>
            </tr>
            <tr>
                <td><form:label path="appUserRole"><spring:message code="label.role"/></form:label></td>
                <td><form:select path="appUserRole" multiple="true">
                    <form:options items="${appUserRoleList}" itemValue="id" itemLabel="role"/>
                </form:select></td>
                <td><form:errors path="appUserRole"/></td>
            </tr>
            <tr>
                <td><form:label path="enabled"><spring:message code="label.enabled"/></form:label></td>
                <td><form:checkbox path="enabled"/></td>
                <td><form:errors path="enabled"/></td>
            </tr>
            <tr>
                <td><form:label path="firstName"><spring:message code="label.firstName"/></form:label></td>
                <td><form:input path="firstName"/></td>
                <td><form:errors path="firstName"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName"><spring:message code="label.surname"/></form:label></td>
                <td><form:input path="lastName"/></td>
                <td><form:errors path="lastName"/></td>
            </tr>
            <tr>
                <td><form:label path="pesel.PESEL"><spring:message code="label.pesel"/></form:label></td>
                <td><form:input path="pesel.PESEL"/></td>
                <td><form:errors path="pesel.PESEL"/></td>
            </tr>
            <tr>
                    <%--              userAddress pole w klasie AppUser  --%>
                <td><form:label path="userAddress"><spring:message code="label.address"/></form:label></td>
                <td><form:select path="userAddress">
                    <%--              addressesList == model attribute   --%>
                    <c:forEach items="${addressesList}" var="address">
                        <option value="${address.id}" ${address.id == selectedAddress ? 'selected="selected"' : ''}>${address.address}
                        </option>
                    </c:forEach>
                </form:select></td>
                <td><form:errors path="userAddress"/></td>
            </tr>
            <tr>
                <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email"/></td>
            </tr>
            <tr>
                <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
                <td><form:input path="telephone"/></td>
                <td><form:errors path="telephone"/></td>
            </tr>

<%--            capcha --%>
            <tr>
                <td colspan="3">
                    <div class="g-recaptcha" data-sitekey="6LcxWxAaAAAAAFJO_mz78P7_zNOoEONnBQGzvvHG"></div>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                        <%--                    <input type="submit" value=<spring:message code="submit.addUser"/>> --%>
                    <c:if test="${appUser.id == 0}">
                        <input type="submit" value=<spring:message code="submit.addUser"/>>
                    </c:if>
                    <c:if test="${appUser.id != 0}">
                        <input type="submit" value=<spring:message code="submit.editUser"/>>
                    </c:if>
                </td>
            </tr>
        </table>

        <h3><spring:message code="label.userList"/></h3>
        <c:if test="${!empty appUserList}">
            <table class="data">
                <tr>
                    <th><spring:message code="label.firstName"/></th>
                    <th><spring:message code="label.surname"/></th>
                    <th><spring:message code="label.email"/></th>
                    <th><spring:message code="label.telephone"/></th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${appUserList}" var="appUser">
                    <tr>
                        <td>${appUser.firstName} </td>
                        <td>${appUser.lastName} </td>
                        <td>${appUser.email}</td>
                        <td>${appUser.telephone}</td>
                            <%--                        href link do usuniecia appUser zczytanego, podanego w atrybucie w AppUserController--%>
                            <%--                        @RequestMapping(value = "/appUsers")--%>
                            <%--                        public String showAppUsers(Model model, HttpServletRequest request) {--%>
                            <%--                        long appUserId = ServletRequestUtils.getLongParameter(request, "appUserId", -1);--%>

                            <%--                        if( appUserId > 0) {--%>
                            <%--                        model.addAttribute("appUser", appUserService.getAppUser(appUserId));--%>
                            <%--                        } else {--%>
                            <%--                        model.addAttribute("appUser", new AppUser());--%>
                            <%--                        }--%>

                            <%--                        model.addAttribute("appUserList", appUserService.listAppUser());--%>

                            <%--                        return "appUser";--%>
                            <%--                        }--%>
                        <td><a href="delete/${appUser.id}.html">delete</a></td>
                        <td><a href="appUsers.html?appUserId=${appUser.id}">edit</a></td>
                        <td><a href="/generatePdf-${appUser.id}">pdf</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </form:form>
</div>
</body>
</html>
