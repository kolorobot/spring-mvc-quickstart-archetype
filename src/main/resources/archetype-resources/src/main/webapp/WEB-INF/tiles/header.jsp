<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Demo project</a>
        <div class="nav-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <security:authorize access="!isAuthenticated()">
                    <li><a href='<s:url value="/signin"></s:url>'>Sign in</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li><a href='<s:url value="/logout"></s:url>'>Logout (<security:authentication property="principal.username"/>)</a></li>
                </security:authorize>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>