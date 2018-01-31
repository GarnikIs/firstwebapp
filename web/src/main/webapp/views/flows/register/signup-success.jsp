<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/30/2017
  Time: 01:40
  To change this template use File | Settings | File Templates.
--%>

<div class="wrapper">

    <%-- Include Flows Header --%>
    <%@include file="../flows_shared/flows_header.jsp" %>

        <%-- Content --%>
        <div class="container">
            <div class="row">
                <div class="col-sm-offset-4 col-sm-4">
                    <div class="text-center">
                        <h1>Welcome!</h1>
                        <h3>onlineshopping.com</h3>
                        <h6>You can use your email address as username to login!</h6>
                        <div>
                            <a href="${contextRoot}/login" class="btn btn-lg btn-success">Login Here</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <%-- Include Flows Footer --%>
    <%@include file="../flows_shared/flows_footer.jsp" %>

</div>
