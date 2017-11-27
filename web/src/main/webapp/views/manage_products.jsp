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
                            <label class="control-label col-md-4" for="name">Product name:</label>
                            <div class="col-md-8">
                                <sf:input type="text" id="name" class="form-control" path="name"
                                          placeholder="Product Name"/>
                                <sf:errors path="name" cssClass="help-block" element="em"/>
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
                            <label class="control-label col-md-4" for="description">Product description:</label>
                            <div class="col-md-8">
                                <sf:textarea type="text" id="description" class="form-control" path="description"
                                             placeholder="Product Description"/>
                                <sf:errors path="description" cssClass="help-block" element="em"/>
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
                                           itemLabel="name"
                                           itemValue="categoryId"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" id="submit" class="btn btn-primary" name="submit" value="Save">
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
</div>
