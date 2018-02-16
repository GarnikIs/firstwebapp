<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <%@include file="./shared/category_sidebar.jsp"%>
        </div>

        <div class="col-lg-9">

                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="${contextRoot}/resources/images/banner/1.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="${contextRoot}/resources/images/banner/2.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="${contextRoot}/resources/images/banner/3.jpg" alt="Third slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block img-fluid" src="${contextRoot}/resources/images/banner/4.jpg" alt="Forth slide">
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                            <a href="#"><img class="card-img-top" id="${product.productName}" src="${contextRoot}/resources/images/${product.code}.jpg" alt="${product.productName}"></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="${contextRoot}/product/${product.productType.productTypeId}/details">
                                            ${product.productName}
                                    </a>
                                </h4>
                                <security:authorize access="hasAuthority('USER')">
                                    <p>&#8381;&nbsp; ${product.unitPrice}</p>
                                </security:authorize>
                                <p class="card-text">${product.productDescription}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>