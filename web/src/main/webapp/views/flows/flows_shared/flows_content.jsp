<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/30/2017
  Time: 02:25
  To change this template use File | Settings | File Templates.
--%>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h4>Registration - Personal Info</h4>
                    </div>
                    <div class="panel-body">
                        <sf:form method="POST" modelAttribute="user" class="form-horizontal"
                                 id="registerForm">
                            <div class="form-group">
                                <label for="firstName" class="control-label col-md-4">First Name</label>
                                <div class="col-md-8">
                                    <sf:input type="text" path="firstName" class="form-control"
                                              placeholder="First Name"/>
                                    <sf:errors path="firstName" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="lastName" class="control-label col-md-4">Last Name</label>
                                <div class="col-md-8">
                                    <sf:input type="text" path="lastName" class="form-control"
                                              placeholder="Last Name"/>
                                    <sf:errors path="lastName" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="control-label col-md-4">Email</label>
                                <div class="col-md-8">
                                    <sf:input type="text" path="email" class="form-control"
                                              placeholder="abc@zyx.com"/>
                                    <sf:errors path="email" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="phoneNumber" class="control-label col-md-4">Phone Number</label>
                                <div class="col-md-8">
                                    <sf:input type="text" path="phoneNumber" class="form-control"
                                              placeholder="XXXXXXXXXX" maxlength="15"/>
                                    <sf:errors path="phoneNumber" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="password" class="control-label col-md-4">Password</label>
                                <div class="col-md-8">
                                    <sf:input type="password" path="password" class="form-control"
                                              placeholder="Password"/>
                                    <sf:errors path="password" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="confirmPassword" class="control-label col-md-4">Confirm Password</label>
                                <div class="col-md-8">
                                    <sf:input type="password" path="confirmPassword" class="form-control"
                                              placeholder="Retype password"/>
                                    <sf:errors path="confirmPassword" cssClass="help-block" element="em"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="role" class="control-label col-md-4">Select Role</label>
                                <div class="col-md-8">
                                    <label class="radio-inline">
                                        <sf:radiobutton path="role" value="USER" checked="checked"/> User
                                    </label>
                                    <label class="radio-inline">
                                        <sf:radiobutton path="role" value="SUPPLIER"/> Supplier
                                    </label>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                    <button type="submit" name="_eventId_billing" class="btn btn-primary">
                                        Billing Info <span class="glyphicon glyphicon-chevron-right"></span>
                                    </button>
                                </div>
                            </div>
                        </sf:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>