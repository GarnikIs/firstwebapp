<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Gor--%>
  <%--Date: 11/30/2017--%>
  <%--Time: 01:40--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%--&lt;%&ndash;<script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_address_line = "<spring:message code='error.message.insert.address.line'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_city = "<spring:message code='error.message.insert.city'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_zip_code = "<spring:message code='error.message.insert.zip.code'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_state = "<spring:message code='error.message.insert.state'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_country = "<spring:message code='error.message.insert.country'/>";&ndash;%&gt;--%>
<%--&lt;%&ndash;</script>&ndash;%&gt;--%>

<%--<div class="wrapper"--%>
    <%--&lt;%&ndash; Include Flows Header &ndash;%&gt;--%>
    <%--<%@include file="../flows_shared/flows_header.jsp" %>--%>

    <%--&lt;%&ndash; Content &ndash;%&gt;--%>
        <%--<div class="container">--%>
            <%--<div class="row">--%>
                <%--<div class="col-md-6 col-md-offset-3">--%>
                    <%--<div class="panel panel-primary">--%>
                        <%--<div class="panel-heading">--%>
                            <%--<h4><spring:message code="registration.address.info"/></h4>--%>
                        <%--</div>--%>
                        <%--<div class="panel-body">--%>
                            <%--<sf:form method="POST" modelAttribute="billing" class="form-horizontal"--%>
                                     <%--id="billingForm">--%>
                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-4" for="addressLine">--%>
                                        <%--<spring:message code="registration.address.line"/>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-8">--%>
                                        <%--<spring:message code='registration.address.line' var="placeholder"/>--%>
                                        <%--<sf:input type="text" id="addressLine" path="addressLine" class="form-control"--%>
                                                  <%--placeholder="${placeholder}" />--%>
                                        <%--<sf:errors path="addressLine" cssClass="help-block" element="em"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-4" for="city">--%>
                                        <%--<spring:message code="registration.city"/>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-8">--%>
                                        <%--<spring:message code='registration.city' var="placeholder"/>--%>
                                        <%--<sf:input type="text" id="city" path="city" class="form-control"--%>
                                                  <%--placeholder="${placeholder}" />--%>
                                        <%--<sf:errors path="city" cssClass="help-block" element="em"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-4" for="zipCode">--%>
                                        <%--<spring:message code="registration.zip.code"/>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-8">--%>
                                        <%--<sf:input type="text" id="zipCode" path="zipCode" class="form-control"--%>
                                                  <%--placeholder="XXXXXX" />--%>
                                        <%--<sf:errors path="zipCode" cssClass="help-block" element="em"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-4" for="state">--%>
                                        <%--<spring:message code="registration.state"/>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-8">--%>
                                        <%--<spring:message code='registration.state' var="placeholder"/>--%>
                                        <%--<sf:input type="text" id="state" path="state" class="form-control"--%>
                                                  <%--placeholder="${placeholder}" />--%>
                                        <%--<sf:errors path="state" cssClass="help-block" element="em"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-4" for="country">--%>
                                        <%--<spring:message code="registration.country"/>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-8">--%>
                                        <%--<spring:message code='registration.country' var="placeholder"/>--%>
                                        <%--<sf:input type="text" id="country" path="country" class="form-control"--%>
                                                  <%--placeholder="${placeholder}" />--%>
                                        <%--<sf:errors path="country" cssClass="help-block" element="em"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                                <%--<div class="form-group">--%>
                                    <%--<div class="col-md-offset-4 col-md-8">--%>
                                        <%--<button type="submit" name="_eventId_personal" class="btn btn-primary">--%>
                                            <%--<span class="glyphicon glyphicon-chevron-left"></span>--%>
                                            <%--<spring:message code="registration.personal.result"/>--%>
                                        <%--</button>--%>
                                        <%--<button type="submit" name="_eventId_confirm" class="btn btn-primary">--%>
                                            <%--<spring:message code="registration.confirm.info"/>--%>
                                            <%--<span class="glyphicon glyphicon-chevron-right"></span>--%>
                                        <%--</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</sf:form>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--&lt;%&ndash; Include Flows Footer &ndash;%&gt;--%>
    <%--<%@include file="../flows_shared/flows_footer.jsp" %>--%>
<%--</div>--%>