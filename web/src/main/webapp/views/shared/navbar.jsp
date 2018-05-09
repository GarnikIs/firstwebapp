<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 01:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<script>
    window.userRole = "${userModel.role}";
</script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${contextRoot}/home"><h3 class="my-4"><spring:message code="online.shop"/></h3></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
            aria-controls="navbarResponsive"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav">
            <li id="home" class="nav-item">
                <a class="nav-link" href="${contextRoot}/home">
                    <spring:message code="navbar.title.home"/>
                </a>
            </li>
            <li id="products" class="nav-item">
                <a class="nav-link" href="${contextRoot}/show/all/products">
                    <spring:message code="navbar.title.products"/>
                </a>
            </li>
            <security:authorize access="hasAuthority('ADMIN')">
                <li id="manageProducts" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/manage/products">
                        <spring:message code="navbar.title.manage.products"/>
                    </a>
                </li>
            </security:authorize>
            <li id="about" class="nav-item">
                <a class="nav-link" href="${contextRoot}/about">
                    <spring:message code="navbar.title.about"/>
                </a>
            </li>
            <li id="contact" class="nav-item">
                <a class="nav-link" href="${contextRoot}/contact"><spring:message code="navbar.title.contacts"/></a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <%--<security:authorize access="isAnonymous()">--%>
                <%--<li id="register" class="nav-item">--%>
                    <%--<a class="nav-link" href="${contextRoot}/register">--%>
                        <%--<span class="glyphicon glyphicon-user"></span>--%>
                        <%--<spring:message code="navbar.title.registration"/>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li id="login" class="nav-item">--%>
                    <%--<a class="nav-link" href="${contextRoot}/login">--%>
                        <%--<span class="glyphicon glyphicon-log-in"></span>--%>
                        <%--<spring:message code="navbar.title.login"/>--%>
                    <%--</a>--%>
                <%--</li>--%>
            <%--</security:authorize>--%>
            <%--<security:authorize access="hasAuthority('ADMIN') || hasAuthority('USER')">--%>
            <security:authorize access="hasAuthority('ADMIN')">
                <li class="dropdown" id="userCart">
                    <a href="javascript:void(0)" style="display: inline-block"
                       class="nav-link dropdown-toggle"
                       id="dropdownMenu1" data-toggle="dropdown">${userModel.fullName}
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <%--<security:authorize access="hasAuthority('USER')">--%>
                            <%--<li>--%>
                                <%--<a href="${contextRoot}/cart/show">--%>
                                    <%--<span class="glyphicon glyphicon-shopping-cart"></span>--%>
                                    <%--<span class="badge">${userModel.cart.cartLines}</span>--%>
                                    <%--- &#8381; ${userModel.cart.grandTotal}--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li class="devider" role="separator"></li>--%>
                        <%--</security:authorize>--%>
                        <li><a href="${contextRoot}/perform-logout">Logout</a></li>
                    </ul>
                </li>
            </security:authorize>
        </ul>
    </div>
    <%@include file="language_bar.jsp" %>
</nav>