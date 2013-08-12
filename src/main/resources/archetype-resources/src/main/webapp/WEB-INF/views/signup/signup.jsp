<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form class="form-narrow form-horizontal" method="post" modelAttribute="signupForm">

    <fieldset>
        <legend>Please Sign Up</legend>
        <form:errors path="" element="p" class="text-error"/>
        <div class="form-group">
            <label for="email" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <form:input path="email" class="form-control" cssErrorClass="form-control" id="email" placeholder="Email address"/>
                <form:errors path="email" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-lg-2 control-label">Password</label>
            <div class="col-lg-10">
                <form:password path="password" class="form-control" id="password" placeholder="Password"/>
                <form:errors path="password" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Sign up</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <p>Already have an account? <a href='<s:url value="/signin"/>'>Sign In</a></p>
            </div>
        </div>
    </fieldset>
</form:form>
