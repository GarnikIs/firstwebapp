<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/17/2017
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<h4 class="my-4"><spring:message code="online.shop"/> </h4>
<div class="list-group">
    <c:forEach items="${categories}" var="category">
        <a href="${contextRoot}/show/category/${category.categoryId}/products" id="${category.categoryName}" class="list-group-item">${category.categoryName}</a>
    </c:forEach>
</div>
