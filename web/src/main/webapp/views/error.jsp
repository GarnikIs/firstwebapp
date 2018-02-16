<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/15/2017
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><spring:message code="online.shop"/> - ${title}</title>

    <%-- START CSS --%>

    <!-- Bootstrap Core CSS -->
    <%--Somtimes it is being invisibel and all css fucked up--%>
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${css}/bootstrap.css" rel="stylesheet">--%>

    <!-- Bootstrap Readable Theme CSS -->
    <%--Somtimes it is being invisibel and all css fucked up--%>
    <link href="${css}/bootstrap-readable-theme-changed.css" rel="stylesheet">

    <!-- Bootstrap DataTables CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/appcustom.css" rel="stylesheet">

    <!-- Bootstrap Theme CSS -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

    <%-- END CSS --%>

</head>

<body>

<div class="wrapper">
    <!-- Navigation bar for error page -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${contextRoot}/home"><spring:message code="navbar.title.home"/></a>
            </div>
        </div>
    </nav>

    <!-- Page Content -->
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="jumbotron">
                        <h1>${errorTitle}</h1>
                        </hr>
                        <blockquote>
                            ${errorDescription}
                        </blockquote>
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
