<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 25.10.2020
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>

<%--    <!-- Bootstrap CSS -->--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">--%>

<%--    <style>--%>
<%--        .bd-placeholder-img {--%>
<%--            font-size: 1.125rem;--%>
<%--            text-anchor: middle;--%>
<%--            -webkit-user-select: none;--%>
<%--            -moz-user-select: none;--%>
<%--            user-select: none;--%>
<%--        }--%>

<%--        @media (min-width: 768px) {--%>
<%--            .bd-placeholder-img-lg {--%>
<%--                font-size: 3.5rem;--%>
<%--            }--%>
<%--        }--%>
<%--    </style>--%>


    <!-- Custom styles for this template -->
<%--    <link href="sticky-footer.css" rel="stylesheet">--%>
</head>
<body>

<%--<!-- Begin page content -->--%>
<%--<main class="flex-shrink-0">--%>
<%--    <div class="container">--%>
<%--        <h1 class="mt-5">Sticky footer</h1>--%>
<%--        <p class="lead">Pin a footer to the bottom of the viewport in desktop browsers with this custom HTML and CSS.</p>--%>
<%--        <p>Use <a href="../examples/sticky-footer-navbar/">the sticky footer with a fixed navbar</a> if need be, too.</p>--%>
<%--    </div>--%>
<%--</main>--%>

<%--<footer class="footer footerAlign">--%>
<%--    <div class="container">--%>
<%--        <span class="text-muted">Place sticky footer content here.</span>--%>
<%--    </div>--%>
<%--</footer>--%>

<footer class="footer mt-auto py-3 bg-dark footerAlign">
    <div class="container">
        <span class="text-muted"><spring:message code="footer.text"/></span>
    </div>
</footer>

</body>
</html>

