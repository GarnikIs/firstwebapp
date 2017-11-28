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
                        <%--TODO later - must be changed --%>
                        <script>
                            window.categoryId = '';
                        </script>
                        <ol class="breadcrumb">
                            <li>All Products</li>
                        </ol>
                    </c:if>
                    <c:if test="${userClickedCategoryProducts == true}">
                        <%--TODO later - must be changed --%>
                        <script>
                            window.categoryId = ${category.categoryId};
                        </script>
                        <ol class="breadcrumb">
                            <li>
                                <a href="/web/show/all/products" class="link_black"title="Go to All Products">
                                    All Products
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
                    <table id="actualProductList" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th id="first"></th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Available</th>
                                <th>Details</th>
                                <th>Add Cart</th>
                            </tr>
                        </thead>
                        <%-- table body is going here--%>
                        <%--<tfoot>--%>
                            <%--<tr>--%>
                                <%--<th></th>--%>
                                <%--<th>Name</th>--%>
                                <%--<th>Brand</th>--%>
                                <%--<th>Price</th>--%>
                                <%--<th>Available</th>--%>
                                <%--<th>Details</th>--%>
                                <%--<th>Add Cart</th>--%>
                            <%--</tr>--%>
                        <%--</tfoot>--%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>