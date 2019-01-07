<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Gor--%>
  <%--Date: 11/30/2017--%>
  <%--Time: 01:40--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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

    <title><spring:message code="online.shop"/> - ${registerModel.title}</title>
    <script>
        window.menu = "${registerModel.title}";
        window.category = "${category.categoryName}";
        window.contextRoot = "${contextRoot}";
        window.currentUrl = "${currentUrl}";
        window.currentLang = "${registerModel.language.key}";

        var error_blank_first_name = "<spring:message code='error.message.insert.first.name'/>";
        var error_blank_last_name = "<spring:message code='error.message.insert.last.name'/>";
        var error_blank_email = "<spring:message code='error.message.blank.email'/>";
        var error_blank_phone = "<spring:message code='error.message.insert.phone.number'/>";
        var error_blank_password = "<spring:message code='error.message.blank.password'/>";
        var error_blank_confirm_password = "<spring:message code='error.message.insert.confirm.password'/>";

        var error_blank_address_line = "<spring:message code='error.message.insert.address.line'/>";
        var error_blank_city = "<spring:message code='error.message.insert.city'/>";
        var error_blank_zip_code = "<spring:message code='error.message.insert.zip.code'/>";
        var error_blank_state = "<spring:message code='error.message.insert.state'/>";
        var error_blank_country = "<spring:message code='error.message.insert.country'/>";
    </script>

    <%-- START CSS --%>

    <!-- Bootstrap Core CSS -->
    <%-- Somtimes it is invisible and all css is fucked up --%>
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${css}/bootstrap.css" rel="stylesheet">--%>

    <!-- Bootstrap Readable Theme CSS -->
    <%-- Somtimes it is invisible and all css is fucked up --%>
    <link href="${css}/bootstrap-readable-theme-changed.css" rel="stylesheet">

    <!-- Bootstrap DataTables CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/appcustom.css" rel="stylesheet">

    <!-- Bootstrap Theme CSS -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

    <%-- Language Bar Support CSS --%>
    <link rel="stylesheet" href="${css}/languageswitcher.css">

    <%-- awesome font icons link --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

    <%-- Language Bar Support JQuery and JS --%>
    <%--<script src="${js}/jquery.min.1.5.0.js"></script>--%>
    <script src="${js}/languageswitcher.js"></script>

    <!-- Angular -->
    <script src="${js}/angular.js"></script>


    <!-- NPM  -->
    <%--<script src="${js}/npm.js"></script>--%>

    <!-- Products Controller  -->
    <script src="${js}/productsController.js"></script>

    <%-- END JS --%>

</head>

<body>

    <!-- Navigation bar is included here -->
    <%--<%@include file="flows_navbar.jsp" %>--%>
    <%@include file="../../shared/navbar.jsp" %>

</body>

</html>
