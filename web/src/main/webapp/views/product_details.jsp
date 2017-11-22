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
                <li>${product.name}</li>
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
            <h3>${product.name}</h3>
            <hr/>
            <p>${product.description}</p>
            <hr/>
            <h4>Price:<strong>&#8377; ${product.unitPrice}</strong></h4>
            <hr/>
            <h6>Available:${product.quantity}</h6>
            <a href="${contextRoot}/cart/add/${product.productId}/product"
               title="Add to Cart" class="btn btn-success">Add to Cart
                <span class='glyphicon glyphicon-shopping-cart'></span>
            </a>
            <a href="${contextRoot}/show/all/products"
               title="Back to All Products" class="btn btn-primary">Back</a>
        </div>
    </div>
</div>