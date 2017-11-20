<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/17/2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<h1 class="my-4">Shop Name</h1>
<div class="list-group">
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/show/category/${category.categoryId}/products" id="${category.name}" class="list-group-item">${category.name}</a>
    </c:forEach>
</div>
