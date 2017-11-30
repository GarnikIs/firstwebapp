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
                            <h4>Personal Details</h4>
                        </div>
                        <div class="panel-body">
                            <div class="text-center">
                                <p><strong>Full Name:</strong>
                                    ${registerModel.user.firstName} ${registerModel.user.lastName}
                                </p>
                                <p><strong>Email:</strong>
                                    ${registerModel.user.email}
                                </p>
                                <p><strong>Phone Number:</strong>
                                    ${registerModel.user.phoneNumber}
                                </p>
                                <p><strong>Role:</strong>
                                    ${registerModel.user.role}
                                </p>
                                <p>
                                    <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Billing Address</h4>
                        </div>
                        <div class="panel-body">
                            <div class="text-center">
                                <p><strong>Address Line:</strong>
                                    ${registerModel.billing.addressLine}
                                </p>
                                <p><strong>City:</strong>
                                    ${registerModel.billing.city}
                                </p>
                                <p><strong>Zip Code:</strong>
                                    ${registerModel.billing.zipCode}
                                </p>
                                <c:if test="${registerModel.billing.state != ''}">
                                    <p><strong>State:</strong>
                                        ${registerModel.billing.state}
                                    </p>
                                </c:if>
                                <p><strong>Country:</strong>
                                    ${registerModel.billing.country}
                                </p>
                                <p>
                                    <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4">
                    <div class="text-center">
                        <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
                    </div>
                </div>
            </div>
        </div>

    <%-- Include Flows Footer --%>
    <%@include file="../flows_shared/flows_footer.jsp" %>

</div>
