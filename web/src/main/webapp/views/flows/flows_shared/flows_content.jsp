<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Gor--%>
  <%--Date: 11/30/2017--%>
  <%--Time: 02:25--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%--&lt;%&ndash;<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>&ndash;%&gt;--%>

<%--&lt;%&ndash;<script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_first_name = "<spring:message code='error.message.insert.first.name'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_last_name = "<spring:message code='error.message.insert.last.name'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_email = "<spring:message code='error.message.blank.email'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_phone = "<spring:message code='error.message.insert.phone.number'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_password = "<spring:message code='error.message.blank.password'/>";&ndash;%&gt;--%>
    <%--&lt;%&ndash;var error_blank_confirm_password = "<spring:message code='error.message.insert.confirm.password'/>";&ndash;%&gt;--%>
<%--&lt;%&ndash;</script>&ndash;%&gt;--%>

<%--<div class="content">--%>
    <%--<div class="container">--%>
        <%--<div class="row">--%>
            <%--<div class="col-md-6 col-md-offset-3">--%>
                <%--<div class="panel panel-primary">--%>
                    <%--<div class="panel-heading">--%>
                        <%--<h4><spring:message code="registration.personal.info"/></h4>--%>
                    <%--</div>--%>
                    <%--<div class="panel-body">--%>
                        <%--<sf:form method="POST" modelAttribute="user" class="form-horizontal"--%>
                                 <%--id="registerForm">--%>
                            <%--<div class="form-group">--%>
                                <%--<label for="firstName" class="control-label col-md-4">--%>
                                    <%--<spring:message code="registration.first.name"/>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8">--%>
                                    <%--<spring:message code='registration.first.name' var="placeholder"/>--%>
                                    <%--<sf:input type="text" path="firstName" class="form-control"--%>
                                              <%--placeholder="${placeholder}"/>--%>
                                    <%--<sf:errors path="firstName" cssClass="help-block" element="em"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<label for="lastName" class="control-label col-md-4">--%>
                                    <%--<spring:message code="registration.last.name"/>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8">--%>
                                    <%--<spring:message code='registration.last.name' var="placeholder"/>--%>
                                    <%--<sf:input type="text" path="lastName" class="form-control"--%>
                                              <%--placeholder="${placeholder}"/>--%>
                                    <%--<sf:errors path="lastName" cssClass="help-block" element="em"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<label for="email" class="control-label col-md-4">--%>
                                    <%--<spring:message code="registration.email"/>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8">--%>
                                    <%--<sf:input type="text" path="email" class="form-control"--%>
                                              <%--placeholder="abc@zyx.com"/>--%>
                                    <%--<sf:errors path="email" cssClass="help-block" element="em"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<label for="phoneNumber" class="control-label col-md-4">--%>
                                    <%--<spring:message code="registration.phone.number"/>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8">--%>
                                    <%--<sf:input type="text" path="phoneNumber" class="form-control"--%>
                                              <%--placeholder="XXXXXXXXXX" maxlength="15"/>--%>
                                    <%--<sf:errors path="phoneNumber" cssClass="help-block" element="em"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<label for="password" class="control-label col-md-4">--%>
                                    <%--<spring:message code="registration.password"/>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8">--%>
                                    <%--<spring:message code='registration.password' var="placeholder"/>--%>
                                    <%--<sf:input type="password" path="password" class="form-control"--%>
                                              <%--placeholder="${placeholder}"/>--%>
                                    <%--<sf:errors path="password" cssClass="help-block" element="em"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="form-group">--%>
                                <%--<label for="confirmPassword" class="control-label col-md-4">--%>
                                    <%--<spring:message code="registration.password.confirm"/>--%>
                                <%--</label>--%>
                                <%--<div class="col-md-8">--%>
                                    <%--<spring:message code='registration.password.confirm' var="placeholder"/>--%>
                                    <%--<sf:input type="password" path="confirmPassword" class="form-control"--%>
                                              <%--placeholder="${placeholder}"/>--%>
                                    <%--<sf:errors path="confirmPassword" cssClass="help-block" element="em"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<div class="col-md-offset-4 col-md-8">--%>
                                    <%--<button type="submit" name="_eventId_billing" class="btn btn-primary">--%>
                                        <%--<spring:message code="registration.redirect.address.info"/>--%>
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
<%--</div>--%>