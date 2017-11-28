<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/25/2017
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div class="row">
        <c:if test="${not empty message}">
            <div class="col-xs-12">
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${message}
                </div>
            </div>
        </c:if>
        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4>Product Management</h4>
                </div>
                <div class="panel-body">
                    <%-- Form Elements --%>
                    <sf:form class="form-horizontal" modelAttribute="product"
                             action="${contextRoot}/manage/products"
                             method="post"
                             enctype="multipart/form-data">

                        <div class="form-group">
                            <label class="control-label col-md-4" for="productName">Product name:</label>
                            <div class="col-md-8">
                                <sf:input type="text" id="productName" class="form-control" path="productName"
                                          placeholder="Product Name"/>
                                <sf:errors path="productName" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="brand">Brand name:</label>
                            <div class="col-md-8">
                                <sf:input type="text" id="brand" class="form-control" path="brand"
                                          placeholder="Brand Name"/>
                                <sf:errors path="brand" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="productDescription">Product description:</label>
                            <div class="col-md-8">
                                <sf:textarea type="text" id="productDescription" class="form-control" path="productDescription"
                                             placeholder="Product Description"/>
                                <sf:errors path="productDescription" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="unitPrice">Product price:</label>
                            <div class="col-md-8">
                                <sf:input type="number" id="unitPrice" class="form-control" path="unitPrice"
                                          placeholder="Product Price"/>
                                <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="quantity">Product quantity:</label>
                            <div class="col-md-8">
                                <sf:input type="number" id="quantity" class="form-control" path="quantity"
                                          placeholder="Product Quantity"/>
                            </div>
                        </div>
                        <%-- Fila  element for image upload --%>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="file">Choose image:</label>
                            <div class="col-md-8">
                                <sf:input type="file" id="file" class="form-control" path="file"/>
                                <sf:errors path="file" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="productCategoryId">Select Category:</label>
                            <div class="col-md-8">
                                <sf:select id="productCategoryId" class="form-control" path="productCategoryId"
                                           items="${categories}"
                                           itemLabel="categoryName"
                                           itemValue="categoryId"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" id="submit" class="btn btn-primary" name="submit" value="Save">
                                <c:if test="${product.productId == 0}">
                                    <button style="float: right" type="button" data-toggle="modal"
                                            data-target="#myCategoryModal"
                                            class="btn btn-warning btn-xs">Add Category</button>
                                </c:if>
                                <sf:hidden path="productId"/>
                                <sf:hidden path="code"/>
                                <sf:hidden path="active"/>
                                <sf:hidden path="productSupplierId"/>
                                <sf:hidden path="purchases"/>
                                <sf:hidden path="views"/>

                            </div>
                        </div>

                    </sf:form>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <h3>Available Products</h3>
            </hr>
        </div>

        <div class="col-xs-12">
            <%-- Products table for Admin --%>
            <table id="adminProductsTable" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>&#160;</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Active</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <%-- table body is going here--%>
                <%--<tfoot>--%>
                <%--<tr>--%>
                <%--<th>Id</th>--%>
                <%--<th>&#160;</th>--%>
                <%--<th>Name</th>--%>
                <%--<th>Quantity</th>--%>
                <%--<th>Price</th>--%>
                <%--<th>Active</th>--%>
                <%--<th>Edit</th>--%>
                <%--</tr>--%>
                <%--</tfoot>--%>
            </table>
        </div>
    </div>

    <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                    <h4 class="modal-title">Add New Category</h4>
                </div>
                <div class="modal-body">
                    <sf:form class="form-horizontal" id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="post">
                        <div class="form-group">
                            <label for="categoryName" class="control-label col-md-4">Category Name</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="categoryName" id="categoryName" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="categoryDescription" class="control-label col-md-4">Category Description</label>
                            <div class="col-md-8">
                                <sf:textarea cols="" rows="5" type="text" path="categoryDescription"
                                             id="categoryDescription" class="form-control"></sf:textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-primary" value="Add Category"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
