<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>
<script>
    lightbox.option({
        'resizeDuration': 200,
        'wrapAround': true
    })
</script>

<div class="container">
    <div class="row">
        <%-- Displays sidebar --%>
        <div class="col-md-3">
            <%@include file="./shared/category_sidebar.jsp" %>
        </div>

        <%-- Displays actual categories and products --%>
        <div class="col-md-9">
            <%-- Added breadcrump component --%>
            <div class="row">
                <div class="col-md-12">
                    <c:if test="${userClickedAllProducts == true}">
                        <%--TODO later - must be changed --%>
                        <script>
                            window.categoryId = '';
                        </script>
                        <ol class="breadcrumb">
                            <li><spring:message code="show.all.products"/> </li>
                        </ol>
                    </c:if>
                    <c:if test="${userClickedCategoryProducts == true}">
                        <%--TODO later - must be changed --%>
                        <script>
                            window.categoryId = ${category.categoryType.categoryTypeId};
                        </script>
                        <ol class="breadcrumb">
                            <li>
                                <a href="/web/show/all/products" class="link_black"title="Go to All Products">
                                    <spring:message code="show.all.products"/>
                                </a>
                            </li>
                            <li>${category.categoryName}</li>
                        </ol>
                    </c:if>
                </div>
            </div>
            <%-- Displaying actual products --%>
            <div class="row">
                <div class="col-xs-12">
                    <div class="container-fluid">
                        <div class="table-responsive">
                            <table id="actualProductList" class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th id="first"></th>
                                        <th><spring:message code="table.column.name"/></th>
                                        <th><spring:message code="table.column.description"/></th>
                                        <th><spring:message code="table.column.details"/></th>
                                        <%--<security:authorize access="hasAuthority('USER')">--%>
                                            <th><spring:message code="table.column.price"/></th>
                                        <%--</security:authorize>--%>
                                        <security:authorize access="hasAuthority('ADMIN')">
                                            <%--<th><spring:message code="table.column.price"/></th>--%>
                                            <th><spring:message code="table.column.edit"/></th>
                                        </security:authorize>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>