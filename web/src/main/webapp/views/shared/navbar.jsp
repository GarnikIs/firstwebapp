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

<%-- Navidation --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Online Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id="home" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/home">Home</a>
                </li>
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li id="products" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/show/all/products">View Products</a>
                </li>
                <security:authorize access="hasAuthority('ADMIN')">
                    <li id="manageProducts" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
                    </li>
                </security:authorize>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/contact">Contact</a>
                </li>
            </ul>
            <ul class="navbar-nav navbar-right">
                <security:authorize access="isAnonymous()">
                    <li id="register" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/register">Registration</a>
                    </li>
                    <li id="login" class="nav-item">
                        <a class="nav-link" href="${contextRoot}/login">Login</a>
                    </li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li class="dropdown">
                        <a href="javascript:void(0)" style="display: inline-block"
                           class="nav-link dropdown-toggle"
                           id="dropdownMenu1" data-toggle="dropdown">${userModel.fullName}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                            <security:authorize access="hasAuthority('USER')">
                                <li>
                                    <a href="${contextRoot}/cart">
                                        <span class="glyphicon glyphicon-shopping-cart"></span>
                                        <span class="badge">${userModel.cart.cartLines}</span>
                                        - &#8377; ${userModel.cart.grandTotal}
                                    </a>
                                </li>
                                <li class="devider" role="separator"></li>
                            </security:authorize>
                            <li><a href="${contextRoot}/perform-logout">Logout</a></li>
                        </ul>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>

