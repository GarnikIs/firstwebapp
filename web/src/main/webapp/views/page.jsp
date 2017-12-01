<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/15/2017
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}">

    <title>Online Shop - ${title}</title>
    <script>
        window.menu = "${title}";
        window.category = "${category.categoryName}";
        window.contextRoot = "${contextRoot}";
    </script>

    <%-- START CSS --%>

    <!-- Bootstrap Core CSS -->
    <%-- Somtimes it is invisibel and all css is fucked up --%>
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${css}/bootstrap.css" rel="stylesheet">--%>

    <!-- Bootstrap Readable Theme CSS -->
    <%-- Somtimes it is invisibel and all css is fucked up --%>
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

    <!-- Bootstrap DataTables CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/appcustom.css" rel="stylesheet">

    <!-- Bootstrap Theme CSS -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

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

    <!-- JQuery Data Tables  -->
    <script src="${js}/jquery.dataTables.js"></script>

    <!-- Bootstrap Data Tables -->
    <script src="${js}/dataTables.bootstrap.js"></script>

    <!-- Boot Box -->
    <script src="${js}/bootbox.min.js"></script>

    <!-- Custom Javascript  -->
    <script src="${js}/appcustom.js"></script>

    <!-- Angular -->
    <script src="${js}/angular.js"></script>


    <!-- NPM  -->
    <%--<script src="${js}/npm.js"></script>--%>

    <!-- Products Controller  -->
    <script src="${js}/productsController.js"></script>

    <%-- END JS --%>

</head>

<body>

<div class="wrapper">
    <!-- Navigation bar is included here -->
    <%@include file="./shared/navbar.jsp" %>


    <!-- Page Content -->
    <div class="content">
        <%-- Home Content only when user clicks home --%>
        <c:if test="${userClickedHome == true}">
            <%@include file="home.jsp" %>
        </c:if>

        <%-- About Us content only when user clicks About --%>
        <c:if test="${userClickedAbout == true}">
            <%@include file="about.jsp" %>
        </c:if>

        <%-- Contact Us content only when user clicks Contact --%>
        <c:if test="${userClickedContact == true}">
            <%@include file="contact.jsp" %>
        </c:if>

        <%-- Products content for All Products or Category Products --%>
        <c:if test="${userClickedAllProducts == true || userClickedCategoryProducts == true}">
            <%@include file="products.jsp" %>
        </c:if>

        <%-- Manage Products content --%>
        <c:if test="${userClickedManageProducts == true}">
            <%@include file="manage_products.jsp" %>
        </c:if>

        <%-- Single product content --%>
        <c:if test="${userClickedProductDetails == true}">
            <%@include file="product_details.jsp" %>
        </c:if>
    </div>

    <!-- Footer is included here -->
    <%@include file="./shared/footer.jsp" %>


</div>
</body>

</html>
