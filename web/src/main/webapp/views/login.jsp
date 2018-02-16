<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 12/1/2017
  Time: 01:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<c:set var="currentUrl" value="${requestScope['javax.servlet.forward.request_uri']}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><spring:message code="online.shop"/> - ${title}</title>
    <script>
        window.menu = "${title}";
        window.category = "${category.categoryName}";
        window.contextRoot = "${contextRoot}";
        window.currentUrl = "${currentUrl}";
        window.currentLang = "${language.key}";
    </script>

    <%-- START CSS --%>

    <!-- Bootstrap Core CSS -->
    <%-- Somtimes it is invisibel and all css is fucked up --%>
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${css}/bootstrap.css" rel="stylesheet">--%>

    <!-- Bootstrap Readable Theme CSS -->
    <%-- Somtimes it is invisibel and all css is fucked up --%>
    <link href="${css}/bootstrap-readable-theme-changed.css" rel="stylesheet">

    <!-- Bootstrap DataTables CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/appcustom.css" rel="stylesheet">

    <!-- Bootstrap Theme CSS -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

    <%-- Language Bar Support CSS --%>
    <link rel="stylesheet" href="${css}/languageswitcher.css">

    <%-- END CSS --%>


    <%-- START JS--%>

    <!-- jQuery -->
    <script src="${js}/jquery.min.js"></script>

    <!-- JQuery Validator  -->
    <script src="${js}/jquery.validate.js"></script>

    <%-- Popper in javascript --%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>

    <!-- Bootstrap Core -->
    <script src="${js}/bootstrap.min.js"></script>

    <!-- Custom Javascript  -->
    <script src="${js}/appcustom.js"></script>

    <%-- Language Bar Support JQuery and JS --%>
    <%--<script src="${js}/jquery.min.1.5.0.js"></script>--%>
    <script src="${js}/languageswitcher.js"></script>

    <%-- END JS --%>
    <script>
        var error_blank_email = "<spring:message code='error.message.blank.email'/>";
        var error_blank_password = "<spring:message code='error.message.blank.password'/>";
    </script>

</head>

<body>

<div class="wrapper">
    <!-- Navigation bar -->
    <%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark" role="navigation">--%>
        <%--<div class="container">--%>
            <%--<div class="navbar-header">--%>
                <%--<a class="navbar-brand" href="${contextRoot}/home">Home</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</nav>--%>
    <%@include file="shared/navbar.jsp" %>

    <!-- Page Content -->
    <div class="content">

        <div class="container">
            <%-- Appears only when user credentioals are wrong --%>
            <c:if test="${not empty errorMessage}">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="alert alert-danger">${errorMessage}</div>
                    </div>
                </div>
            </c:if>
            <%-- Appears only when user has logged out --%>
            <c:if test="${not empty logoutMessage}">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="alert alert-success">${logoutMessage}</div>
                    </div>
                </div>
            </c:if>
            <div class="row">
                <div class="col-md-offset-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Login</h4>
                        </div>
                        <div class="panel-body">
                            <form action="${contextRoot}/login" method="post" class="form-horizontal" id="loginForm">
                                <div class="form-group">
                                    <label for="username" class="control-label col-md-4">
                                        <spring:message code="registration.email"/>:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="text" id="username" class="form-control"
                                                  name="username" placeholder="abc@zyx.com"/>
                                        <sf:errors path="username" cssClass="help-block" element="em"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="control-label col-md-4">
                                        <spring:message code="registration.password"/>:
                                    </label>
                                    <div class="col-md-8">
                                        <input type="password" id="password" class="form-control"
                                               name="password" placeholder="<spring:message code="registration.password"/>"/>
                                        <sf:errors path="password" cssClass="help-block" element="em"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-4 col-md-8">
                                        <input type="submit" value="<spring:message code="navbar.title.login"/>" class="btn btn-primary"/>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="pane-footer">
                            <div class="text-right" style="padding: 0 20px 10px 0;">
                                <spring:message code="not.registered"/> -
                                <a href="${contextRoot}/register">
                                    <spring:message code="register.link"/>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer is included here -->
    <%@include file="./shared/footer.jsp" %>


</div>
</body>

</html>
