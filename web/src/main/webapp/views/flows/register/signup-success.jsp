<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Gor--%>
  <%--Date: 11/30/2017--%>
  <%--Time: 01:40--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<div class="wrapper">

    <%-- Include Flows Header --%>
    <%@include file="../flows_shared/flows_header.jsp" %>

        <%-- Content --%>
        <div class="container">
            <div class="row">
                <div class="col-sm-offset-4 col-sm-4">
                    <div class="text-center">
                        <h1>
                            <spring:message code="registration.welcome"/>
                        </h1>
                        <h6>
                            <spring:message code="registration.welcome.message"/>
                        </h6>
                        <div>
                            <a href="${contextRoot}/login" class="btn btn-lg btn-primary">
                                <spring:message code="navbar.title.login"/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <%-- Include Flows Footer --%>
    <%@include file="../flows_shared/flows_footer.jsp" %>

</div>
