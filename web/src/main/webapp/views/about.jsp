<%--
  Created by IntelliJ IDEA.
  User: Gor
  Date: 11/16/2017
  Time: 02:04
  To change this template use File | Settings | File Templates.
--%>

<div class="container">
    <div class="row">
        <%-- Displaying product image --%>
        <div class="col-xs-12 col-sm-4">
            <div class="thumbnail">
                <img src="${images}/face.jpg" class="img img-responsive">
            </div>
            <label for="founder" style="font-size: 20px; font-weight: bold;">
                <u><i><spring:message code="crazy.founder.title"/></i></u>
            </label>
            <br>
            <span style="font-size: 18px; font-weight: bold;" id="founder">
                <i><spring:message code="crazy.founder"/></i>
            </span>
            <hr/>
            <h4><u><i><spring:message code="crazy.contacts"/></i></u></h4>
            <label>
                <u><i><spring:message code="crazy.contact.email"/>:</i></u>
            </label>
            <div class="position-relative">
                <span>
                    <spring:message code="crazy.email.1"/>
                </span>
                <%--<span>--%>
                    <%--<spring:message code="crazy.email.2"/>--%>
                <%--</span>--%>
                <%--<span>--%>
                    <%--<spring:message code="crazy.email.3"/>--%>
                <%--</span>--%>
                <br>
                <br>
            </div>
            <label for="phoneNumber">
                <u><i><spring:message code="crazy.contact.phone"/>:</i></u>
            </label>
            <div class="position-relative">
                <span id="phoneNumber">
                    <spring:message code="crazy.phone.1"/>
                    <br>
                    <spring:message code="crazy.phone.2"/>
                </span>
            </div>
        </div>
        <%-- Displaying product description --%>
        <div class="col-xs-12 col-sm-8">
            <h4>
                <u><i><spring:message code="crazy.hand.made.about"/></i></u>
            </h4>
            <p>
                <spring:message code="crazy.hand.made.description"/>
            </p>
            <hr/>
        </div>
    </div>
</div>