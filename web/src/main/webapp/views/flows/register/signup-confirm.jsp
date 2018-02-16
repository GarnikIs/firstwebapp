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
                <div class="col-sm-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4><spring:message code="registration.personal.result"/></h4>
                        </div>
                        <div class="panel-body">
                            <div class="text-center">
                                <p><strong>
                                    <spring:message code="registration.full.name"/>:
                                </strong>
                                    ${registerModel.user.firstName} ${registerModel.user.lastName}
                                </p>
                                <p>
                                    <strong>
                                        <spring:message code="registration.email"/>:
                                    </strong>
                                    ${registerModel.user.email}
                                </p>
                                <p>
                                    <strong>
                                        <spring:message code="registration.phone.number"/>:
                                    </strong>
                                    ${registerModel.user.phoneNumber}
                                </p>
                                <p>
                                    <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">
                                        <spring:message code="registration.edit.info"/>
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>
                                <spring:message code="registration.address.title"/>
                            </h4>
                        </div>
                        <div class="panel-body">
                            <div class="text-center">
                                <p>
                                    <strong>
                                        <spring:message code="registration.address.line"/>:
                                    </strong>
                                    ${registerModel.billing.addressLine}
                                </p>
                                <p>
                                    <strong>
                                        <spring:message code="registration.city"/>:
                                    </strong>
                                    ${registerModel.billing.city}
                                </p>
                                <p>
                                    <strong>
                                        <spring:message code="registration.zip.code"/>:
                                    </strong>
                                    ${registerModel.billing.zipCode}
                                </p>
                                <c:if test="${registerModel.billing.state != ''}">
                                    <p>
                                        <strong>
                                            <spring:message code="registration.state"/>:
                                        </strong>
                                        ${registerModel.billing.state}
                                    </p>
                                </c:if>
                                <p>
                                    <strong>
                                        <spring:message code="registration.country"/>:
                                    </strong>
                                    ${registerModel.billing.country}
                                </p>
                                <p>
                                    <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">
                                        <spring:message code="registration.edit.info"/>
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <div class="text-center">
                        <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">
                            <spring:message code="registration.confirm.info"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>

    <%-- Include Flows Footer --%>
    <%@include file="../flows_shared/flows_footer.jsp" %>

</div>
