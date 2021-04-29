<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

    <!-- Bootstrap core CSS -->
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>


<body>
<div><tiles:insertAttribute name="header"/></div>
<%--<div><tiles:insertAttribute name="menu"/></div>--%>
<div><tiles:insertAttribute name="body"/></div>
<div><tiles:insertAttribute name="footer"/></div>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>--%>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="//getbootstrap.com/docs/4.0/assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="//getbootstrap.com/docs/5.0/assets/js/vendor/popper.min.js"></script>
<script src="//getbootstrap.com/docs/5.0/dist/js/bootstrap.min.js"></script>
<script src="//getbootstrap.com/docs/5.0/dist/js/bootstrap.bundle.js"></script>

</body>
</html>

