<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<h2><s:message code="view.index.title" /></h2>
<p>
	Welcome to the Spring MVC demo application!
</p>

<security:authorize access="!isAuthenticated()">
	<p>
		You are not authenticated. Click <a href='<s:url value="user"></s:url>'>here</a> to signin.<br/>
		Please use the following credentials: <strong>user</strong>, password: <strong>demo</strong>.
	</p>
</security:authorize>	
