<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<div class="container">
    <div class="row">
        <%-- Displaying product image --%>
        <div class="col-xs-12 col-sm-4">
            <div class="thumbnail">
                <img src="${images}/Gazzan.jpg" class="img img-responsive">
            </div>
        </div>
        <%-- Displaying product description --%>
        <div class="col-xs-12 col-sm-8">
            <h3>${product.productName}</h3>
            <hr/>
            <u><i>Contact</i></u>
            <h6>${product.productDescription}</h6>
            <hr/>
        </div>
    </div>
</div>