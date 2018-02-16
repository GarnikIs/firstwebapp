<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/25/2017
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<script>
    var popup_title = "<spring:message code='popup.title'/>";
    var popup_title_info = "<spring:message code='popup.title.info'/>";
    var error_add_prop_en = "<spring:message code='error.message.add.property.english'/>";
    var error_add_prop_ru = "<spring:message code='error.message.add.property.russian'/>";
    var error_blank_username = "<spring:message code='error.message.blank.username'/>";
    var error_blank_email = "<spring:message code='error.message.blank.email'/>";
    var error_blank_password = "<spring:message code='error.message.blank.password'/>";
    var error_min_length = "<spring:message code='error.message.min.length'/>";
    var popup_active_question = "<spring:message code='popup.activate.question'/>";
    var popup_deactive_question = "<spring:message code='popup.deactivate.question'/>";
    var error_add_price = "<spring:message code='error.message.add.price'/>";
    var error_price_min_value = "<spring:message code='error.message.price.min.value'/>";
</script>

<div class="container">
    <div class="row">
        <c:if test="${not empty errorMessage}">
            <div class="col-xs-12">
                <div class="alert alert-danger alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${errorMessage}
                </div>
            </div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="col-xs-12">
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${successMessage}
                </div>
            </div>
        </c:if>
        <div class="col-md-offset-2 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="label.product.management"/></h4>
                </div>
                <div class="panel-body">
                    <%-- Form Elements --%>
                    <sf:form id="productForm" class="form-horizontal" modelAttribute="product"
                             action="${contextRoot}/manage/products"
                             method="post"
                             enctype="multipart/form-data">

                        <div class="form-group">
                            <label class="control-label col-md-4" for="productNameEn">Name in English:</label>
                            <div class="col-md-8">
                                <sf:input type="text" id="productNameEn" class="form-control" path="productNameEn"
                                          placeholder="Product Name English"/>
                                <sf:errors path="productNameEn" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="productNameRu">Имя на Русском:</label>
                            <div class="col-md-8">
                                <sf:input type="text" id="productNameRu" class="form-control" path="productNameRu"
                                          placeholder="Product Name Russian"/>
                                <sf:errors path="productNameRu" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="productDescriptionEn">Description in English:</label>
                            <div class="col-md-8">
                                <sf:textarea type="text" id="productDescriptionEn" class="form-control" path="productDescriptionEn"
                                             placeholder="Product Description in English"/>
                                <sf:errors path="productDescriptionEn" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="productDescriptionRu">Описание на Русском:</label>
                            <div class="col-md-8">
                                <sf:textarea type="text" id="productDescriptionRu" class="form-control" path="productDescriptionRu"
                                             placeholder="Product Description in Russian"/>
                                <sf:errors path="productDescriptionRu" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="unitPrice">
                                <spring:message code="label.management.product.price"/>:
                            </label>
                            <div class="col-md-8">
                                <sf:input type="number" id="unitPrice"  class="form-control" path="unitPrice"
                                          placeholder="Product Price"/>
                                <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <%-- File  element for image upload --%>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="file">
                                <spring:message code="label.management.product.image"/>:
                            </label>
                            <div class="col-md-8">
                                <sf:input type="file" id="file" class="form-control" path="file"/>
                                <sf:errors path="file" cssClass="help-block" element="em"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="productCategoryTypeId">
                                <spring:message code="label.management.select.category"/>:
                            </label>
                            <div class="col-md-8">
                                <sf:select id="productCategoryTypeId" class="form-control" cssStyle="height: 40px;" path="productCategoryType.categoryTypeId"
                                           items="${categories}"
                                           itemLabel="categoryName"
                                           itemValue="categoryType.categoryTypeId"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" id="submit" class="btn btn-primary" name="submit" value="Save">
                                <%--<c:if test="${productId == 0}">--%>
                                    <button style="float: right" type="button" data-toggle="modal" data-target="#myCategoryModal"
                                            class="btn btn-warning btn-xs">
                                        <spring:message code="label.management.add.category"/>:
                                    </button>
                                <%--</c:if>--%>
                                <sf:hidden path="productType.productTypeId"/>
                                <sf:hidden path="code"/>
                                <sf:hidden path="active"/>
                                <sf:hidden path="productUser.userId"/>
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
            <div class="container-fluid">
                <div class="table-responsive">
                    <%-- Products table for Admin --%>
                    <table id="adminProductsTable" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>&#160;</th>
                                <th><spring:message code="table.column.name"/></th>
                                <th><spring:message code="table.column.description"/></th>
                                <th><spring:message code="table.column.price"/></th>
                                <th><spring:message code="table.column.active"/></th>
                                <th><spring:message code="table.column.edit"/></th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                    <h4 class="modal-title">
                        <spring:message code="add.new.category"/>
                    </h4>
                </div>
                <div class="modal-body">
                    <sf:form class="form-horizontal" id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category" method="post">
                        <div class="form-group">
                            <label for="categoryNameEn" class="control-label col-md-4">Name in English</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="categoryNameEn" id="categoryNameEn" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoryNameRu" class="control-label col-md-4">Имя на Русском</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="categoryNameRu" id="categoryNameRu" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-primary" value="<spring:message code='label.management.add.category'/>"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
