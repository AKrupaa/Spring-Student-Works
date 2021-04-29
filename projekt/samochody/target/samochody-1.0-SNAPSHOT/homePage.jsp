<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Arkadiusz
  Date: 17.12.2020
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <%--    <meta charset="utf-8">--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>

    <%--    <!-- Bootstrap CSS -->--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">--%>

</head>
<body class="bg-dark">
<!-- Option 2: Separate Popper and Bootstrap JS -->
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"--%>
<%--        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"--%>
<%--        crossorigin="anonymous"></script>--%>

<main class="flex-shrink-0 text-white">
    <%--    <div class="container">--%>
    <%--        <br>--%>
    <%--        <br>--%>
    <%--        <br>--%>
    <%--        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eget rutrum nulla. Etiam sodales sem non--%>
    <%--        rhoncus dapibus. Quisque vitae risus ultrices felis aliquam sagittis. Ut eu eros sed risus maximus commodo. Nam--%>
    <%--        congue sagittis odio, vitae congue diam lacinia quis. Fusce sodales leo eu enim molestie, et vehicula arcu--%>
    <%--        convallis. Fusce pulvinar nulla sed aliquam vulputate. Aliquam libero purus, sodales quis justo ac, gravida--%>
    <%--        varius elit. Fusce quis ex at dui ultrices maximus. Nunc sagittis id lacus a commodo. In cursus augue in--%>
    <%--        hendrerit tempus. Aenean id eros sodales, posuere quam vitae, ultrices mi. Orci varius natoque penatibus et--%>
    <%--        magnis dis parturient montes, nascetur ridiculus mus. Suspendisse et venenatis elit.--%>

    <%--        Fusce blandit erat arcu, vel tempus risus consequat quis. Morbi iaculis arcu bibendum lorem gravida, at--%>
    <%--        vestibulum elit volutpat. Cras aliquam, sem sit amet iaculis gravida, magna neque sollicitudin urna, mollis--%>
    <%--        viverra massa sem nec mi. Nullam aliquam commodo luctus. Nam in sapien orci. Ut scelerisque urna id tellus--%>
    <%--        posuere, ac molestie sem vestibulum. Curabitur ullamcorper rhoncus pulvinar.--%>

    <%--        Mauris lobortis elit leo, in volutpat augue cursus non. Quisque aliquam urna eget malesuada euismod. Maecenas eu--%>
    <%--        libero libero. Mauris in elit nulla. Maecenas ex lectus, euismod et velit non, tincidunt fermentum ligula.--%>
    <%--        Nullam consectetur rhoncus tortor at tempor. Donec ultrices fermentum eros at ornare. Sed placerat auctor urna,--%>
    <%--        a lobortis magna mattis at. Suspendisse sit amet varius ligula, a pretium justo. Morbi eu magna et velit laoreet--%>
    <%--        venenatis ac a velit. Morbi tincidunt varius convallis. Proin rhoncus erat vitae aliquet mollis. Cras tempus--%>
    <%--        mauris id diam maximus pretium. Nam semper, elit in auctor fringilla, est felis finibus magna, et faucibus neque--%>
    <%--        libero in felis. Vestibulum pulvinar faucibus tellus, et tincidunt libero cursus at. Duis metus orci, elementum--%>
    <%--        id mauris non, sagittis sodales lorem.--%>

    <%--        Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aliquam elit nunc, auctor--%>
    <%--        vitae euismod quis, rhoncus at leo. Nam quis erat vitae tortor sagittis accumsan. Nulla euismod mi id ligula--%>
    <%--        pharetra, ut posuere dui viverra. Integer vitae mauris lectus. Fusce ac dictum orci, non pellentesque augue.--%>
    <%--        Aliquam bibendum elementum nisi vel placerat. Aliquam commodo non lacus eget iaculis. In ac imperdiet nunc.--%>

    <%--        Nunc in ligula semper, aliquam nunc gravida, cursus metus. Integer iaculis dignissim lobortis. Cras eros sem,--%>
    <%--        faucibus ac sem non, eleifend pretium odio. Nulla in dui diam. Sed cursus nisi sodales, tristique est vel,--%>
    <%--        feugiat erat. Integer vel fermentum felis, eget tempor elit. Nulla facilisi. Sed in mollis tortor, at aliquam--%>
    <%--        sapien. Donec sollicitudin ultrices leo, a sodales ex elementum sed. Duis vitae posuere turpis. Phasellus--%>
    <%--        molestie vel lectus ac ultricies. Fusce dui mi, mollis vel elit quis, suscipit volutpat magna. Vivamus lacinia,--%>
    <%--        augue a pharetra iaculis, risus nibh porta nibh, ac porttitor metus nibh a nisi. Integer scelerisque id nulla--%>
    <%--        imperdiet imperdiet. Sed rutrum sed arcu vitae cursus. Curabitur faucibus lorem arcu, et viverra diam euismod a.--%>

    <%--        Etiam ullamcorper sollicitudin blandit. Morbi et odio vitae diam congue iaculis a sed orci. Integer augue elit,--%>
    <%--        gravida sit amet neque vitae, pretium ultricies ante. Integer dapibus est lacus, non dictum ipsum vehicula non.--%>
    <%--        Quisque pulvinar elementum ligula imperdiet vehicula. Nulla vel efficitur turpis, eu aliquam nibh. Duis volutpat--%>
    <%--        lacus non massa consectetur, at rutrum eros egestas. Vestibulum ante ipsum primis in faucibus orci luctus et--%>
    <%--        ultrices posuere cubilia curae;--%>

    <%--        Aenean gravida commodo ipsum, vel vestibulum nisi. Nullam quis ligula quis risus hendrerit rutrum eu vitae--%>
    <%--        justo. Maecenas porta egestas sagittis. Nunc viverra ullamcorper ultricies. Pellentesque ligula mi, tempus sit--%>
    <%--        amet augue sit amet, pharetra eleifend mi. Maecenas urna dui, rhoncus sollicitudin tortor nec, tempus mollis--%>
    <%--        diam. Suspendisse potenti. Sed ultricies lacus at convallis feugiat. Nunc non pulvinar libero, vel pulvinar--%>
    <%--        massa. Duis sagittis, augue in aliquam efficitur, nisi velit fermentum libero, sit amet rhoncus nulla neque quis--%>
    <%--        lectus. Mauris in diam sit amet dui auctor luctus. In quis neque rhoncus, gravida massa nec, varius nisl.--%>

    <%--        Nulla non ante vel turpis aliquet finibus. Suspendisse velit turpis, dictum ac faucibus id, gravida id augue.--%>
    <%--        Praesent vel mollis elit, ac fermentum massa. Nam dui tortor, pretium nec eros ac, mollis sollicitudin lacus.--%>
    <%--        Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer eleifend lacus lorem. Quisque lorem nibh,--%>
    <%--        consequat vel nunc nec, semper mattis mi. Vivamus dignissim eros ac enim vehicula, sit amet sagittis magna--%>
    <%--        volutpat. Nullam laoreet et mauris id eleifend. Suspendisse sit amet mauris bibendum, mattis arcu vel, pharetra--%>
    <%--        risus. Donec semper libero nec est vehicula, sed facilisis mi auctor. Donec facilisis convallis mi a pretium.--%>
    <%--        Fusce molestie, velit pulvinar imperdiet pretium, ligula orci venenatis enim, ut tincidunt tellus sapien vel--%>
    <%--        nisl.--%>

    <%--        Vestibulum condimentum arcu justo, eu convallis dolor sodales condimentum. Pellentesque eu ligula a purus ornare--%>
    <%--        sollicitudin. Morbi ullamcorper nisl orci. Fusce vel vehicula metus. Donec dignissim hendrerit ante non--%>
    <%--        efficitur. In leo sem, ornare eget interdum ac, sagittis vitae massa. Proin fringilla et arcu in posuere.--%>
    <%--        Aliquam a tempus nisi. Curabitur quis felis at nisi sodales posuere a ac mauris. Fusce nibh mauris, pulvinar--%>
    <%--        condimentum arcu vitae, consectetur luctus urna.--%>

    <%--        Vestibulum elit nunc, egestas sit amet sapien id, suscipit euismod justo. Nullam eu aliquet dui. Pellentesque--%>
    <%--        sit amet placerat ligula. Morbi vitae vehicula justo, eu molestie est. Quisque id magna sagittis, malesuada nisl--%>
    <%--        sit amet, tristique diam. Sed ullamcorper efficitur tempus. Sed efficitur purus at eros ornare, vitae facilisis--%>
    <%--        velit dictum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce--%>
    <%--        ipsum urna, ornare a ante sed, bibendum lobortis dolor. Nullam ac ipsum ante. Maecenas vulputate tristique--%>
    <%--        purus, ac ullamcorper odio consectetur ac. Maecenas urna urna, tincidunt sed ligula a, mattis dignissim mauris.--%>
    <%--        Integer efficitur lectus a accumsan luctus. Duis vestibulum elit vitae velit dictum volutpat. Phasellus sed--%>
    <%--        ultricies turpis, nec porttitor eros. Etiam congue metus venenatis fringilla sollicitudin.--%>

    <%--        <br>--%>
    <%--        ostatni element--%>
    <%--    </div>--%>


    <div class="container">
        <br>
        <br>
        <br>
        <c:if test="${!empty modelRandomCarList}">
            <c:forEach items="${modelRandomCarList}" var="car">


                <div class="row">
                    <div class="col">
                            <%--        <div class="card mb-3">--%>
                        <img class="card-img-top" src="${car.sourceImage}"
                             alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${car.title}</h5>
                            <p class="card-text">${car.description}</p>
<%--                            <p class="card-text"><small class="text-muted">Is rented? ${car.rented}</small></p>--%>
                                <%--                        <a href="#" class="card-link">Card link</a>--%>
                                <%--                        <a href="#" class="card-link">Another link</a>--%>
                            <a href="/info/purchase/${car.id}" class="btn btn-primary"><spring:message code="rent_now"/></a>
                        </div>
                    </div>
                </div>


            </c:forEach>
        </c:if>

        <br>
        <br>
        <br>
    </div>

    <%--    <div class="container">--%>
    <%--        <div class="row">--%>
    <%--            <div class="col">--%>
    <%--                &lt;%&ndash;        <div class="card mb-3">&ndash;%&gt;--%>
    <%--                <img class="card-img-top" src="/resources/image/lamborghini-aventador-car-profile.png"--%>
    <%--                     alt="Card image cap">--%>
    <%--                <div class="card-body">--%>
    <%--                    <h5 class="card-title">Card title</h5>--%>
    <%--                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to--%>
    <%--                        additional content. This content is a little bit longer.</p>--%>
    <%--                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
    <%--                    <a href="#" class="card-link">Card link</a>--%>
    <%--                    <a href="#" class="card-link">Another link</a>--%>
    <%--                    <a href="/info/purchase/56" class="btn btn-primary">Go somewhere</a>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <div class="row">--%>
    <%--            <div class="col">--%>
    <%--                <img class="card-img-top" src="/resources/image/infiniti-qx60-car-profile.png"--%>
    <%--                     alt="Card image cap">--%>
    <%--                <div class="card-body">--%>
    <%--                    <h5 class="card-title">Card title</h5>--%>
    <%--                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to--%>
    <%--                        additional content. This content is a little bit longer.</p>--%>
    <%--                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
    <%--                    <a href="#" class="card-link">Card link</a>--%>
    <%--                    <a href="#" class="card-link">Another link</a>--%>
    <%--                    <a href="/info/purchase/52" class="btn btn-primary">Go somewhere</a>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--        <div class="row">--%>
    <%--            <div class="col">--%>
    <%--                <img class="card-img-top" src="/resources/image/chevrolet-cruze-sedan-car-profile.png"--%>
    <%--                     alt="Card image cap">--%>
    <%--                <div class="card-body">--%>
    <%--                    <h5 class="card-title">Card title</h5>--%>
    <%--                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to--%>
    <%--                        additional content. This content is a little bit longer.</p>--%>
    <%--                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
    <%--                    <a href="#" class="card-link">Card link</a>--%>
    <%--                    <a href="#" class="card-link">Another link</a>--%>
    <%--                    <a href="/info/purchase/56" class="btn btn-primary">Go somewhere</a>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <%--    <div class="container">--%>
    <%--    <c:forEach items="${CarListObject}" var="car">--%>
    <%--        <c:out value="${car.poleObiektu}"></c:out>--%>

    <%--        <div class="row">--%>
    <%--            <div class="col">--%>
    <%--                <img class="card-img-top" src="/resources/image/chevrolet-cruze-sedan-car-profile.png"--%>
    <%--                     alt="Card image cap">--%>
    <%--                <div class="card-body">--%>
    <%--                    <h5 class="card-title">Card title</h5>--%>
    <%--                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to--%>
    <%--                        additional content. This content is a little bit longer.</p>--%>
    <%--                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
    <%--                    <a href="#" class="card-link">Card link</a>--%>
    <%--                    <a href="#" class="card-link">Another link</a>--%>
    <%--                    <a href="#" class="btn btn-primary">Go somewhere</a>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </c:forEach>--%>
    <%--    </div>--%>

    po<br>
    prostu
    dosc
    css
</main>
</body>
</html>

