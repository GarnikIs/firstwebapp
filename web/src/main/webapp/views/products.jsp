<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

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
                        <ol class="breadcrumb">
                            <li class="active">All Products</li>
                        </ol>
                    </c:if>
                    <c:if test="${userClickedCategoryProducts == true}">
                        <ol class="breadcrumb">
                            <li class="active">All Products</li>
                            <li class="active">${category.name}</li>
                        </ol>
                    </c:if>
                </div>
            </div>

            <%-- Displaying actual products --%>
            <div class="row">
                <div class="col-xs-12">
                    <table id="actual_product_list" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>