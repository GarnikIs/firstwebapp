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
                                <h3>Name :
                                    <%--<strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong>--%>
                                </h3>
                                <h4>Email :
                                    <%--<strong>${registerModel.user.email}</strong>--%>
                                </h4>
                                <h4>Contact :
                                    <%--<strong>${registerModel.user.contactNumber}</strong>--%>
                                </h4>
                                <h4>Role :
                                    <%--<strong>${registerModel.user.role}</strong>--%>
                                </h4>
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
                                <%--<p>${registerModel.billing.addressLineOne}, </p>--%>
                                <%--<p>${registerModel.billing.addressLineTwo}, </p>--%>
                                <%--<p>${registerModel.billing.city} -  ${registerModel.billing.postalCode}, </p>--%>
                                <%--<p>${registerModel.billing.state}</p>--%>
                                <%--<p>${registerModel.billing.country}</p>--%>
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
                        <a href="${flowExecutionUrl}&_eventId_success" class="btn btn-lg btn-primary">Confirm</a>
                    </div>
                </div>
            </div>
        </div>

    <%-- Include Flows Footer --%>
    <%@include file="../flows_shared/flows_footer.jsp" %>

</div>
