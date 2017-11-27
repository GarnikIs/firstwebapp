<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 01:25
  To change this template use File | Settings | File Templates.
--%>

<%-- Navidation --%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Online Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li id="home" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/home">Home</a>
                </li>
                <li id="about" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li id="products" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/show/all/products">View Products</a>
                </li>
                <li id="manageProducts" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
                </li>
                <li id="contact" class="nav-item">
                    <a class="nav-link" href="${contextRoot}/contact">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

