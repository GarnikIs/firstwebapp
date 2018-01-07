<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/21/2017
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<div class="container">
    <%-- Breadcrumb --%>
    <div class="row">
        <div class="col-xs-12">
            <ol class="breadcrumb">
                <li><a href="${contextRoot}/show/all/products" class="link_black">All Products</a></li>
                <li>${product.productName}</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <%-- Displaying product image --%>
        <div class="col-xs-12 col-sm-4">
            <div class="thumbnail">
                <img src="${images}/${product.code}.jpg" class="img img-responsive">
            </div>
        </div>
        <%-- Displaying product description --%>
        <div class="col-xs-12 col-sm-8">
            <u><i>Name</i></u>
            <h3>${product.productName}</h3>
            <hr/>
            <u><i>Descrption</i></u>
            <h6>${product.productDescription}</h6>
            <hr/>
            <h4>Price:<strong> - &#8381; ${product.unitPrice}</strong></h4>
            <hr/>
            <c:choose>
                <c:when test="${product.quantity < 1}">
                    <h6>Available - <span style="color:red">&nbsp; Out of Stock</span></h6>
                </c:when>
                <c:otherwise>
                    <h6>Available - ${product.quantity}</h6>
                    <h6>Views - ${product.views}</h6>
                    <%--<h6>Purchases - ${product.purchases}</h6>--%>
                </c:otherwise>
            </c:choose>
            <security:authorize access="hasAuthority('ADMIN')">
                <a href="${contextRoot}/manage/${product.productId}/product"
                   title="Edit ${product.productName}" class="btn btn-warning">Edit
                    <span class='glyphicon glyphicon-pencil'></span>
                </a>
            </security:authorize>

            <a href="${contextRoot}/show/all/products"
               title="Back to All Products" class="btn btn-primary">Back</a>
        </div>
    </div>
</div>