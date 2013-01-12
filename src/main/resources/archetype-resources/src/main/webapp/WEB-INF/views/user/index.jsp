<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h2>Hello <security:authentication property="principal.username" />! </h2>

<p>	
	You are in the restricted area!	
</p>