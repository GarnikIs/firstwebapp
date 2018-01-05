<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Gor--%>
  <%--Date: 12/4/2017--%>
  <%--Time: 00:49--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%--<div class="container">--%>
    <%--<c:if test="${not empty successMessage}">--%>
        <%--<div class="alert alert-success">--%>
            <%--<h3 class="text-center">${successMessage}</h3>--%>
        <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:if test="${not empty errorMessage}">--%>
        <%--<div class="alert alert-danger">--%>
            <%--<h3 class="text-center">${errorMessage}</h3>--%>
        <%--</div>--%>
    <%--</c:if>--%>
    <%--<c:choose>--%>
        <%--<c:when test="${not empty cartLines}">--%>
            <%--<div class="container-fluid">--%>
                <%--<div class="table-responsive">--%>
                    <%--<table id="cart" class="table table-hover table-condensed">--%>
                        <%--<thead>--%>
                        <%--<tr>--%>
                            <%--<th style="width:5%">Image</th>--%>
                            <%--<th style="width:45%; text-align: center">Product</th>--%>
                            <%--<th style="width:10%">Price</th>--%>
                            <%--<th style="width:8%">Quantity</th>--%>
                            <%--<th style="width:22%" class="text-center">Subtotal</th>--%>
                            <%--<th style="width:10%"></th>--%>
                        <%--</tr>--%>
                        <%--</thead>--%>
                        <%--<tbody>--%>
                        <%--<c:forEach items="${cartLines}" var="cartLine">--%>
                            <%--<tr>--%>
                                <%--<td data-th="Image">--%>
                                    <%--<img src="${images}/${cartLine.product.code}.jpg"--%>
                                                                         <%--alt="${cartLine.product.productName}"--%>
                                                                         <%--class="img-responsive cartImage"/>--%>
                                <%--</td>--%>
                                <%--<td data-th="Product">--%>
                                    <%--<div class="row">--%>
                                        <%--<div class="col-sm-10">--%>
                                            <%--<h4 class="nomargin">${cartLine.product.productName}</h4>--%>
                                            <%--<c:if test="${cartLine.available == flase}">--%>
                                                <%--<strong class="unavailable">(Not Available)</strong>--%>
                                            <%--</c:if>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="row">--%>
                                        <%--<div class="col-sm-2">--%>
                                            <%--<p><i>Brand: </i></p>--%>
                                            <%--<p><i>Description: </i></p>--%>
                                        <%--</div>--%>
                                        <%--<div class="col-sm-2"></div>--%>
                                        <%--<div class="col-sm-6">--%>
                                            <%--<p>${cartLine.product.brand}</p>--%>
                                            <%--<p>${cartLine.product.productDescription}</p>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</td>--%>
                                <%--<td data-th="Price">&#8381; ${cartLine.product.unitPrice}</td>--%>
                                <%--<td data-th="Quantity">--%>
                                    <%--<input type="number" id="count_${cartLine.cartLineId}" min="1" max="3"--%>
                                           <%--class="form-control text-center" value="${cartLine.cartLineProductCount}">--%>
                                <%--</td>--%>
                                <%--<td data-th="Subtotal" class="text-center">&#8381; ${cartLine.cartLineTotal}</td>--%>
                                <%--<td class="actions" data-th="">--%>
                                    <%--<button type="button" name="refreshCartProduct" value="${cartLine.cartLineId}" class="btn btn-info btn-sm"><span--%>
                                            <%--class="glyphicon glyphicon-refresh"></span></button>--%>
                                    <%--<a href="${contextRoot}/cart/${cartLine.cartLineId}/delete" class="btn btn-danger btn-sm"><span--%>
                                            <%--class="glyphicon glyphicon-trash"></span></a>--%>
                                <%--</td>--%>
                            <%--</tr>--%>
                        <%--</c:forEach>--%>
                        <%--</tbody>--%>
                        <%--<tfoot>--%>
                        <%--<tr class="visible-xs">--%>
                            <%--<td class="text-center"><strong>Total &#8381; ${userModel.cart.grandTotal}</strong></td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td><a href="${contextRoot}/show/all/products" class="btn btn-warning"><span--%>
                                    <%--class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a></td>--%>
                            <%--<td colspan="3" class="hidden-xs"></td>--%>
                            <%--<td class="hidden-xs text-center"><strong>Total &#8381; ${userModel.cart.grandTotal}</strong></td>--%>
                            <%--<td><a href="#" class="btn btn-success btn-block">Checkout <span--%>
                                    <%--class="glyphicon glyphicon-chevron-right"></span></a></td>--%>
                        <%--</tr>--%>
                        <%--</tfoot>--%>
                    <%--</table>--%>
                <%--</div>--%>
            <%--</div>--%>

        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<div class="jumbotron">--%>
                <%--<div class="text-center">--%>
                    <%--<h1>Your Cart is Empty</h1>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
<%--</div>--%>